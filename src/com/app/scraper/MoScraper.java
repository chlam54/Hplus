package com.app.scraper;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.app.model.OddsDelta;
import com.app.util.MathUtil;
import com.app.util.Util;

public class MoScraper {
	private Document odds = null;
	private Document config = null;
	private Date oddsTime = null;
	private final static Logger logger = Util.getLogger(MoScraper.class);

	public MoScraper() throws IOException {
		refreshData();
	}


	public OddsDelta scrapeOdds(String id, String moId) {
		OddsDelta od = null;
		for (Element fixture : odds.select("Fixture")) {
			if (moId.equals(fixture.attr("id"))) {
				// Odds HAD
				Float wh = Float.parseFloat(fixture.attr("wh"));
				Float wd = Float.parseFloat(fixture.attr("wd"));
				Float wa = Float.parseFloat(fixture.attr("wa"));
				// Odds HDC
				Float ho = Float.parseFloat(fixture.attr("ho"));
				Float ao = Float.parseFloat(fixture.attr("ao"));
				String g = fixture.attr("g");
				Integer gg = Integer.parseInt(fixture.attr("gg"));
				Float gLine = MathUtil.multiply((gg - 1), 0.25f);
				if ("H".equals(g)) {
					gLine = MathUtil.subtract(0, gLine);
				}
				// Odds HIL
				Float oo = Float.parseFloat(fixture.attr("oo"));
				Float uo = Float.parseFloat(fixture.attr("uo"));
				Float li = MathUtil.multiply(Float.parseFloat(fixture.attr("li")), 0.25f);
				//TODO pass time to obj
				od = new OddsDelta(id, Param.bookmakerMO, moId, oddsTime, wh, wd,
						wa, gLine, ho, ao,
						li, oo, uo, null, null, null);
			}
		}
		return od;
	}

	private String searchId(String id, String teamName, String homeName, String awayName) {
		double maxSim = 0;
		String moId = null;
		for (Element fixture : config.select("Fixture")) {
			String th = fixture.attr("th").trim();
			String ta = fixture.attr("ta").trim();
			String tt = fixture.attr("tt").trim();
			double homeSim = Util.similarity(homeName, th);
			double awaySim = Util.similarity(awayName, ta);
			double teamSim = Util.similarity(teamName, tt);
			double sim = homeSim + awaySim + teamSim;
			if (sim > maxSim) {
				maxSim = sim;
				moId = fixture.attr("id").trim();
			}
		}
		return (maxSim > 1.75) ? moId : null;
	}

	public void refreshData() {
		String noCache = "?noCache=" + System.currentTimeMillis();
		try {
			odds = MatchScraper.jsoupConnect(Param.urlMoOdds);
			config = MatchScraper.jsoupConnect(Param.urlMoOddsConfig);
			oddsTime = new Date();
		} catch (Exception e) {
			logger.error("refreshData exception");
		}
	}

}
