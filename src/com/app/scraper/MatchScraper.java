package com.app.scraper;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.app.dao.MatchDaoImpl;
import com.app.dao.DiffChlDaoImpl;
import com.app.dao.DiffFhaDaoImpl;
import com.app.dao.DiffFhlDaoImpl;
import com.app.dao.DiffHadDaoImpl;
import com.app.dao.DiffHdcDaoImpl;
import com.app.dao.DiffHhaDaoImpl;
import com.app.dao.DiffHilDaoImpl;
import com.app.dao.HistoryDaoImpl;
import com.app.intf.MatchDao;
import com.app.intf.DiffChlDao;
import com.app.intf.DiffFhaDao;
import com.app.intf.DiffFhlDao;
import com.app.intf.DiffHadDao;
import com.app.intf.DiffHdcDao;
import com.app.intf.DiffHhaDao;
import com.app.intf.DiffHilDao;
import com.app.intf.HistoryDao;
import com.app.model.Match;
import com.app.model.DiffChl;
import com.app.model.DiffHad;
import com.app.model.DiffHdc;
import com.app.model.DiffHil;
import com.app.model.History;
import com.app.util.URIBuilder;
import com.app.util.Util;

public class MatchScraper {
	private static MatchDao matchDao = new MatchDaoImpl();
	private static HistoryDao historyDao = new HistoryDaoImpl();
	private static DiffChlDao diffChlDao = new DiffChlDaoImpl();
	private static DiffFhaDao diffFhaDao = new DiffFhaDaoImpl();
	private static DiffFhlDao diffFhlDao = new DiffFhlDaoImpl();
	private static DiffHadDao diffHadDao = new DiffHadDaoImpl();
	private static DiffHdcDao diffHdcDao = new DiffHdcDaoImpl();
	private static DiffHhaDao diffHhaDao = new DiffHhaDaoImpl();
	private static DiffHilDao diffHiLDao = new DiffHilDaoImpl();
	private final static Logger logger = Util.getLogger(MatchScraper.class);
	
	public static HashMap<String, InfoResult> scrapeResult(String dateKey) {
		HashMap<String, InfoResult> searchResult = new HashMap<String, InfoResult>();
		int loop = 1;
		boolean next = true;
		while (next) {
			URIBuilder builder = new URIBuilder(Param.urlHkjcGetJson);
			builder.addParameter("jsontype", "search_result.aspx");
			builder.addParameter("startdate", dateKey);
			builder.addParameter("enddate", dateKey);
			builder.addParameter("teamid", "default");
			builder.addParameter("pageno", loop + "");
			logger.info(builder.getURI());

			try {
				JSONArray array = getArrJsoupConnect(builder.getURI());
				if (array.toString().length() < 10) {
					next = false;
					break;
				}
				JSONArray searchMatches = null;
				for (int i = 0; i < array.length(); i++) {
					if ("SearchMatches".equals(array.getJSONObject(i).getString("name"))) {
						searchMatches = array.getJSONObject(i).getJSONArray("matches");
					}
				}
				for (int j = 0; j < searchMatches.length(); j++) {
					JSONObject match = searchMatches.getJSONObject(j);
					String matchId = match.getString("matchID");
					String matchStatus = match.getString("matchStatus");
					Integer homeGoal = null, awayGoal = null, totalGoal = null, corner = null;
					String result = null;
//					if ("EndedAfterFT".equals(match.getJSONObject("liveEvent").getString("matchstate"))
//							|| "EndedAfterPK".equals(match.getJSONObject("liveEvent").getString("matchstate"))
//							|| "EndedAfterET".equals(match.getJSONObject("liveEvent").getString("matchstate"))) {
					if ("false".equals(match.getJSONObject("isIncomplete").getString("matchstate"))){
						JSONArray accScore = match.getJSONArray("accumulatedscore");
						JSONObject firstHT = null;
						JSONObject secondHT = null;
						for (int k = 0; k < accScore.length(); k++) {
							JSONObject temp = accScore.getJSONObject(k);
							if ("FirstHalf".equals(temp.getString("periodvalue")))
								firstHT = temp;
							if ("SecondHalf".equals(temp.getString("periodvalue")))
								secondHT = temp;
						}
						if(secondHT == null) {
							break;	//skip for non-Finished match
						}
						homeGoal = Integer.parseInt(secondHT.getString("home"));
						awayGoal = Integer.parseInt(secondHT.getString("away"));
						result = homeGoal + ":" + awayGoal + "(" + firstHT.getString("home") + ":"
								+ firstHT.getString("away") + ")";
					}
					try {
						corner = Integer.parseInt(match.getString("cornerresult"));
					} catch (Exception e) {
						corner = null;
					}
					InfoResult ir = null;
					if("ResultIn".equals(matchStatus)) {
						ir = new InfoResult(homeGoal, awayGoal, corner, result);
						logger.info(matchId + "::" + ir);
						searchResult.put(matchId, ir);
					} else if("Canceled".equals(matchStatus)) {
						searchResult.put(matchId, null);
					}
				}
				loop++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return searchResult;
	}

	public static void updateResult() {
		MultivaluedHashMap<String, Match> masterMap = new MultivaluedHashMap<String, Match>();
		List<Match> list = matchDao.updateResultList();
		for (Match m : list) {
			String dateKey = Util.parseDate(m.getMatchTime(), "yyyyMMdd");
			masterMap.add(dateKey, m);
		}

		for (String key : masterMap.keySet()) {
			HashMap<String, InfoResult> rMap = scrapeResult(key);
			List<Match> value = masterMap.get(key);
			for (Match m : value) {
				logger.info("updateResult::"+m.getId());
				InfoResult ir = rMap.get(m.getId());
				if(ir != null) {
					m.setResult(ir.getResult());
					m.setResultCorner(ir.getCorner());
					matchDao.updateResult(m);
				} else {
					logger.info("pending incomplete match::"+m.getId());
					//matchDao.deleteResult(m);
				}
			}
		}
	}

	public static void scrape() {
		// Batch Scraping
		Map<String, DiffHad> oddsHad = scrapeOddsHad();
		Map<String, DiffHdc> oddsHandicap = scrapeOddsHandicap();
		Map<String, DiffHil> oddsHiLo = scrapeOddsHil();
		Map<String, DiffChl> oddsCornerHiLo = scrapeOddsCornerHil();
		Timestamp d = Util.parseDate(Util.getHongKongDate());
		
		for (String key : oddsHad.keySet()) {	
			if (matchDao.get(key) == null) {
				Match match = new Match(key, oddsHad.get(key).getMatchNum(), oddsHad.get(key).getMatchDate(),
						oddsHad.get(key).getMatchTime(), oddsHad.get(key).getMatchType(), oddsHad.get(key).getMatchTypeEn(),
						oddsHad.get(key).getHomeName(), oddsHad.get(key).getAwayName(), oddsHad.get(key).getHomeNameEn(),
						oddsHad.get(key).getAwayNameEn(), null, null, d, oddsHad.get(key).getOddsHadHome(),
						oddsHad.get(key).getOddsHadDraw(), oddsHad.get(key).getOddsHadAway(), null, null, null,
						oddsHiLo.get(key).getOddsHiLoLine(), oddsHiLo.get(key).getOddsHiLoHigh(),
						oddsHiLo.get(key).getOddsHiLoLow(), null, null, null, null, null, null, null, null, null, null,
						null, null, null);
				if (oddsHandicap.containsKey(key)) {
					match.setOddsHandicapLine(oddsHandicap.get(key).getOddsHandicapLine());
					match.setOddsHandicapHome(oddsHandicap.get(key).getOddsHandicapHome());
					match.setOddsHandicapAway(oddsHandicap.get(key).getOddsHandicapAway());
				}
				if (oddsCornerHiLo.containsKey(key)) {
					match.setOddsCornerHiLoLine(oddsCornerHiLo.get(key).getOddsCornerHiLoLine());
					match.setOddsCornerHiLoHigh(oddsCornerHiLo.get(key).getOddsCornerHiLoHigh());
					match.setOddsCornerHiLoLow(oddsCornerHiLo.get(key).getOddsCornerHiLoLow());
				}
				Map<String, Object> rfInfo = scrapeRecentForm(match.getMatchDate(), match.getMatchNum());
				match.setRfHome((ArrayList<RecentForm>) rfInfo.get("rfHome"));
				match.setRfAway((ArrayList<RecentForm>) rfInfo.get("rfAway"));
				match.setHomeLRank((Integer) rfInfo.get("homeLRank"));
				match.setAwayLRank((Integer) rfInfo.get("awayLRank"));

				matchDao.save(match);
			} else {
				if (oddsHad.containsKey(key)) {
					DiffHad od = diffHadDao.getLatest(key);
					DiffHad newOd = new DiffHad(key, Param.bookmakerHKJC, Util.parseDate(d),
							oddsHad.get(key).getOddsHadHome(), oddsHad.get(key).getOddsHadAway(), oddsHad.get(key).getOddsHadDraw());
					
					if(od==null || !newOd.equals(od)) {
						logger.info(newOd);
						diffHadDao.save(newOd);
					}
				}
				
				if (oddsHandicap.containsKey(key)) {
					DiffHdc od = diffHdcDao.getLatest(key);
					DiffHdc newOd = new DiffHdc(key, Param.bookmakerHKJC, Util.parseDate(d),
							oddsHandicap.get(key).getOddsHandicapLine(), oddsHandicap.get(key).getOddsHandicapHome(), oddsHandicap.get(key).getOddsHandicapAway());
					
					if(od==null || !newOd.equals(od)) {
						logger.info(newOd);
						diffHdcDao.save(newOd);
					}
				}
				
				if (oddsHiLo.containsKey(key)) {
					DiffHil od = diffHiLDao.getLatest(key);
					DiffHil newOd = new DiffHil(key, Param.bookmakerHKJC, Util.parseDate(d),
							oddsHiLo.get(key).getOddsHiLoLine(), oddsHiLo.get(key).getOddsHiLoHigh(), oddsHiLo.get(key).getOddsHiLoLow());
					
					if(od==null || !newOd.equals(od)) {
						logger.info(newOd);
						diffHiLDao.save(newOd);
					}
				}
			}
			
		}
		updateResult();
	}

	public static Map<String, DiffHad> scrapeOddsHad() {
		Map<String, DiffHad> infoMap = new HashMap<String, DiffHad>();
		URIBuilder builder = new URIBuilder(Param.urlHkjcGetJson);
		builder.addParameter("jsontype", "odds_had.aspx");
		logger.info(builder.getURI());
		Document doc;
		try {
			JSONArray array = getArrJsoupConnect(builder.getURI());
			JSONArray activeMatch = null;
			for (int i = 0; i < array.length(); i++) {
				if ("ActiveMatches".equals(array.getJSONObject(i).getString("name"))) {
					activeMatch = array.getJSONObject(i).getJSONArray("matches");
				}
			}
			for (int j = 0; j < activeMatch.length(); j++) {
				JSONObject match = activeMatch.getJSONObject(j);
				String matchId = match.getString("matchID");
				String matchStatus = match.getString("matchStatus");
				Float oddsHadHome = Float.parseFloat(match.getJSONObject("hadodds").getString("H").split("@")[1]);
				Float oddsHadAway = Float.parseFloat(match.getJSONObject("hadodds").getString("A").split("@")[1]);
				Float oddsHadDraw = Float.parseFloat(match.getJSONObject("hadodds").getString("D").split("@")[1]);

				DiffHad diffHad = new DiffHad(matchId, Param.bookmakerHKJC, Util.parseDate(Util.getHongKongDate()),
						oddsHadHome, oddsHadAway, oddsHadDraw);
				if("Defined".equals(matchStatus)) {
					logger.info(matchId+"::"+diffHad);
					infoMap.put(matchId, diffHad);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoMap;
	}

	public static Map<String, DiffHdc> scrapeOddsHandicap() {
		Map<String, DiffHdc> infoMap = new HashMap<String, DiffHdc>();
		URIBuilder builder = new URIBuilder(Param.urlHkjcGetJson);
		builder.addParameter("jsontype", "odds_hdc.aspx");
		logger.info(builder.getURI());
		Document doc;
		try {
			JSONArray array = getArrJsoupConnect(builder.getURI());
			JSONArray activeMatch = null;
			for (int i = 0; i < array.length(); i++) {
				if ("ActiveMatches".equals(array.getJSONObject(i).getString("name"))) {
					activeMatch = array.getJSONObject(i).getJSONArray("matches");
				}
			}
			for (int j = 0; j < activeMatch.length(); j++) {
				JSONObject match = activeMatch.getJSONObject(j);
				String matchId = match.getString("matchID");
				String matchStatus = match.getString("matchStatus");
				Float oddsHandicapLine = Util.parseLine(match.getJSONObject("hdcodds").getString("HG"));
				Float oddsHandicapHome = Float.parseFloat(match.getJSONObject("hdcodds").getString("H").split("@")[1]);
				Float oddsHandicapAway = Float.parseFloat(match.getJSONObject("hdcodds").getString("A").split("@")[1]);

				DiffHdc diffHdc = new DiffHdc(matchId, Param.bookmakerHKJC, Util.parseDate(Util.getHongKongDate()),
						oddsHandicapLine, oddsHandicapHome, oddsHandicapAway);
				if("Defined".equals(matchStatus)) {
					logger.info(matchId+"::"+diffHdc);
					infoMap.put(matchId, diffHdc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoMap;
	}
	//TODO hilo diff line
	public static Map<String, DiffHil> scrapeOddsHil() {
		Map<String, DiffHil> infoMap = new HashMap<String, DiffHil>();
		URIBuilder builder = new URIBuilder(Param.urlHkjcGetJson);
		builder.addParameter("jsontype", "odds_hil.aspx");
		logger.info(builder.getURI());
		try {
			JSONArray array = getArrJsoupConnect(builder.getURI());
			JSONArray activeMatch = null;
			for (int i = 0; i < array.length(); i++) {
				if ("ActiveMatches".equals(array.getJSONObject(i).getString("name"))) {
					activeMatch = array.getJSONObject(i).getJSONArray("matches");
				}
			}
			for (int j = 0; j < activeMatch.length(); j++) {
				JSONObject match = activeMatch.getJSONObject(j);
				String matchId = match.getString("matchID");
				String matchStatus = match.getString("matchStatus");
				JSONArray lineList = match.getJSONObject("hilodds").getJSONArray("LINELIST");
				JSONObject mainLine = null;
				for (int k = 0; k < lineList.length(); k++) {
					JSONObject line = lineList.getJSONObject(k);
					if ("true".equals(line.getString("MAINLINE"))) {
						mainLine = line;
					}
				}
				Float oddsHiLoLine = Util.parseLine(mainLine.getString("LINE"));
				Float oddsHiLoHigh = Float.parseFloat(mainLine.getString("H").split("@")[1]);
				Float oddsHiLoLow = Float.parseFloat(mainLine.getString("L").split("@")[1]);

				DiffHil infoHil = new DiffHil(matchId, Param.bookmakerHKJC,
						Util.parseDate(Util.getHongKongDate()), 
						oddsHiLoLine, oddsHiLoHigh, oddsHiLoLow);
				if("Defined".equals(matchStatus)) {
					logger.info(matchId+"::"+infoHil);
					infoMap.put(matchId, infoHil);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoMap;
	}

	public static Map<String, DiffChl> scrapeOddsCornerHil() {
		Map<String, DiffChl> infoMap = new HashMap<String, DiffChl>();
		URIBuilder builder = new URIBuilder(Param.urlHkjcGetJson);
		builder.addParameter("jsontype", "odds_chl.aspx");
		logger.info(builder.getURI());
		Document doc;
		try {
			JSONArray array = getArrJsoupConnect(builder.getURI());
			JSONArray activeMatch = null;
			for (int i = 0; i < array.length(); i++) {
				if ("ActiveMatches".equals(array.getJSONObject(i).getString("name"))) {
					activeMatch = array.getJSONObject(i).getJSONArray("matches");
				}
			}
			for (int j = 0; j < activeMatch.length(); j++) {
				JSONObject match = activeMatch.getJSONObject(j);
				String matchId = match.getString("matchID");
				String matchStatus = match.getString("matchStatus");
				JSONArray lineList = match.getJSONObject("chlodds").getJSONArray("LINELIST");
				JSONObject mainLine = null;
				for (int k = 0; k < lineList.length(); k++) {
					JSONObject line = lineList.getJSONObject(k);
					if ("true".equals(line.getString("MAINLINE"))) {
						mainLine = line;
					}
				}
				Float oddsCornerHiLoLine = Util.parseLine(mainLine.getString("LINE"));
				Float oddsCornerHiLoHigh = Float.parseFloat(mainLine.getString("H").split("@")[1]);
				Float oddsCornerHiLoLow = Float.parseFloat(mainLine.getString("L").split("@")[1]);

				DiffChl infoHil = new DiffChl(matchId, Util.parseDate(Util.getHongKongDate()),
						oddsCornerHiLoLine, oddsCornerHiLoHigh, oddsCornerHiLoLow);
				if("Defined".equals(matchStatus)) {
					logger.info(matchId+"::"+infoHil);
					infoMap.put(matchId, infoHil);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoMap;
	}

	public static Map<String, Object> scrapeRecentForm(String matchTime, String matchNum) {
		Map<String, Object> map = new HashMap<String, Object>();

		URIBuilder builder = new URIBuilder(Param.urlHkjcRecentForm);
		builder.addParameter("ci", "zh-HK");
		builder.addParameter("tdate", matchTime); // matchTime - dd-MM-yyyy
		builder.addParameter("tday", matchNum.split(" ")[0]); // matchNum prefix
		builder.addParameter("tnum", matchNum.split(" ")[1]); // matchNum suffix

		Document doc;
		try {
			logger.info(builder.getURI());
			doc = jsoupConnect(builder.getURI());

			Element h2hDiv = doc.select("div#headtohead").get(0);
			Element homeTable = h2hDiv.select("div.content>table").get(0);
			Element awayTable = h2hDiv.select("div.content>table").get(1);

			Integer homeLRank = Util.parseRecentFormRank(doc.select("div#match>div>p").get(0).text().trim());
			Integer awayLRank = Util.parseRecentFormRank(doc.select("div#match>div>p").get(1).text().trim());
			logger.info(homeLRank + "-" + awayLRank);
			map.put("homeLRank", homeLRank);
			map.put("awayLRank", awayLRank);

			ArrayList<RecentForm> rfHomeList = new ArrayList<RecentForm>();
			Elements homeRows = homeTable.select("tr");
			for (int i = 2; i < homeRows.size(); i++) {
				Element row = homeRows.get(i);
				Elements td = row.select("td");

				RecentForm rfHome = parseRecentForm(td);
				rfHomeList.add(rfHome);
				logger.info(rfHome);
			}
			map.put("rfHome", rfHomeList);

			ArrayList<RecentForm> rfAwayList = new ArrayList<RecentForm>();
			Elements awayRows = awayTable.select("tr");
			for (int j = 2; j < awayRows.size(); j++) {
				Element row = awayRows.get(j);
				Elements td = row.select("td");

				RecentForm rfAway = parseRecentForm(td);
				rfAwayList.add(rfAway);
				logger.info(rfAway);
			}
			map.put("rfAway", rfAwayList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	private static History parseRecentForm(Elements elements) {
		String type = elements.get(0).text().trim();
		String date = elements.get(1).text().trim();
		String role = maskRole(elements.get(2).text().trim());
		String agst = elements.get(4).text().trim();
		String result = elements.get(5).text().trim();
		if (result.contains(")")) {
			result = result.split("\\)")[0] + ")";
		}
		Integer goal = Util.parseStatResult(result, false);
		Integer oppGoal = Util.parseStatResult(result, true);
		Integer wdl = Util.parseStatHad(result);
		Float hdcLine = Util.parseLine(elements.get(6).text().trim());
		Float hdcRoi = Util.calHdcRoi(result, hdcLine);
		Float hhadLine = Util.parseLine(elements.get(8).text().trim());
		Integer corner = Util.parseCorner(elements.get(14).text().trim());
		History rf = new History(type, date, role, agst, result, goal, oppGoal, wdl, hdcLine, hdcRoi, hhadLine,
				corner);
		return rf;
	}
	
	private static String maskRole(String str) {
		return ("\u5BA2".equals(str)) ? Param.teamAway : Param.teamHome;
	}

	public static Document jsoupConnect(String uri) throws IOException {
		Util.sleep();
		return Jsoup.connect(uri).ignoreContentType(true).timeout(5000).post();
	}
	
	public static JSONArray getArrJsoupConnect(String uri) throws IOException {
		boolean req2Connect = true;
		JSONArray array = null;
		while(req2Connect) {
			Document doc = jsoupConnect(uri);
			
			try {
				Element jsonData = doc.select("body").get(0);
				array = new JSONArray(jsonData.text());
				req2Connect = false;
			} catch(Exception e) {
				Util.sleep(10000);
				req2Connect = true;
				logger.info("Connection Failure");
			}
		}
		return array;
	}
}
