package com.app.model;

import java.util.ArrayList;
import java.util.Date;

public class Match {

	@Override
	public String toString() {
		return "Match [id=" + id + ", matchNum=" + matchNum + ", matchDate=" + matchDate + ", matchTime=" + matchTime
				+ ", matchType=" + matchType + ", matchTypeEn=" + matchTypeEn + ", homeName=" + homeName + ", awayName="
				+ awayName + ", homeNameEn=" + homeNameEn + ", awayNameEn=" + awayNameEn + ", homeLRank=" + homeLRank
				+ ", awayLRank=" + awayLRank + ", oddsTime=" + oddsTime + ", oddsHadHome=" + oddsHadHome
				+ ", oddsHadDraw=" + oddsHadDraw + ", oddsHadAway=" + oddsHadAway + ", oddsHandicapLine="
				+ oddsHandicapLine + ", oddsHandicapHome=" + oddsHandicapHome + ", oddsHandicapAway=" + oddsHandicapAway
				+ ", oddsHiLoLine=" + oddsHiLoLine + ", oddsHiLoHigh=" + oddsHiLoHigh + ", oddsHiLoLow=" + oddsHiLoLow
				+ ", oddsCornerHiLoLine=" + oddsCornerHiLoLine + ", oddsCornerHiLoHigh=" + oddsCornerHiLoHigh
				+ ", oddsCornerHiLoLow=" + oddsCornerHiLoLow + ", rfHome=" + rfHome + ", rfAway=" + rfAway + ", result="
				+ result + ", resultHomeGoal=" + resultHomeGoal + ", resultAwayGoal=" + resultAwayGoal
				+ ", resultTotalGoal=" + resultTotalGoal + ", resultHad=" + resultHad + ", resultHdcHomeRoi="
				+ resultHdcHomeRoi + ", resultHdcAwayRoi=" + resultHdcAwayRoi + ", resultCorner=" + resultCorner + "]";
	}
	private String id;
	
	private String matchNum;
	private String matchDate;
	private Date matchTime;
	private String matchType;
	private String matchTypeEn;
	
	private String homeName;
	private String awayName;
	private String homeNameEn;
	private String awayNameEn;
	private Integer homeLRank;
	private Integer awayLRank;
	
	private Date oddsTime;
	private Float oddsHadHome;
	private Float oddsHadDraw;
	private Float oddsHadAway;
	private Float oddsHandicapLine;
	private Float oddsHandicapHome;
	private Float oddsHandicapAway;
	private Float oddsHiLoLine;
	private Float oddsHiLoHigh;
	private Float oddsHiLoLow;
	private Float oddsCornerHiLoLine;
	private Float oddsCornerHiLoHigh;
	private Float oddsCornerHiLoLow;
	
	private ArrayList<RecentForm> rfHome;
	private ArrayList<RecentForm> rfAway;
	
	private String result;
	private Integer resultHomeGoal;
	private Integer resultAwayGoal;
	private Integer resultTotalGoal;
	private Integer resultHad;
	private Float resultHdcHomeRoi;
	private Float resultHdcAwayRoi;
	private Integer resultCorner;
	public Match() {}
	public Match(String id, String matchNum, String matchDate, Date matchTime, String matchType, String matchTypeEn, String homeName,
			String awayName, String homeNameEn, String awayNameEn, Integer homeLRank, Integer awayLRank, Date oddsTime,
			Float oddsHadHome, Float oddsHadDraw, Float oddsHadAway, Float oddsHandicapLine, Float oddsHandicapHome,
			Float oddsHandicapAway, Float oddsHiLoLine, Float oddsHiLoHigh, Float oddsHiLoLow, Float oddsCornerHiLoLine,
			Float oddsCornerHiLoHigh, Float oddsCornerHiLoLow, ArrayList<RecentForm> rfHome,
			ArrayList<RecentForm> rfAway, String result, Integer resultHomeGoal, Integer resultAwayGoal,
			Integer resultTotalGoal, Integer resultHad, Float resultHdcHomeRoi, Float resultHdcAwayRoi,
			Integer resultCorner) {
		super();
		this.id = id;
		this.matchNum = matchNum;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.matchType = matchType;
		this.matchTypeEn = matchTypeEn;
		this.homeName = homeName;
		this.awayName = awayName;
		this.homeNameEn = homeNameEn;
		this.awayNameEn = awayNameEn;
		this.homeLRank = homeLRank;
		this.awayLRank = awayLRank;
		this.oddsTime = oddsTime;
		this.oddsHadHome = oddsHadHome;
		this.oddsHadDraw = oddsHadDraw;
		this.oddsHadAway = oddsHadAway;
		this.oddsHandicapLine = oddsHandicapLine;
		this.oddsHandicapHome = oddsHandicapHome;
		this.oddsHandicapAway = oddsHandicapAway;
		this.oddsHiLoLine = oddsHiLoLine;
		this.oddsHiLoHigh = oddsHiLoHigh;
		this.oddsHiLoLow = oddsHiLoLow;
		this.oddsCornerHiLoLine = oddsCornerHiLoLine;
		this.oddsCornerHiLoHigh = oddsCornerHiLoHigh;
		this.oddsCornerHiLoLow = oddsCornerHiLoLow;
		this.rfHome = rfHome;
		this.rfAway = rfAway;
		this.result = result;
		this.resultHomeGoal = resultHomeGoal;
		this.resultAwayGoal = resultAwayGoal;
		this.resultTotalGoal = resultTotalGoal;
		this.resultHad = resultHad;
		this.resultHdcHomeRoi = resultHdcHomeRoi;
		this.resultHdcAwayRoi = resultHdcAwayRoi;
		this.resultCorner = resultCorner;
	}
	public String getId() {
		return id;
	}
	public String getMatchNum() {
		return matchNum;
	}
	public Date getMatchTime() {
		return matchTime;
	}
	public String getMatchType() {
		return matchType;
	}
	public String getMatchTypeEn() {
		return matchTypeEn;
	}
	public String getHomeName() {
		return homeName;
	}
	public String getAwayName() {
		return awayName;
	}
	public String getHomeNameEn() {
		return homeNameEn;
	}
	public String getAwayNameEn() {
		return awayNameEn;
	}
	public Integer getHomeLRank() {
		return homeLRank;
	}
	public Integer getAwayLRank() {
		return awayLRank;
	}
	public Date getOddsTime() {
		return oddsTime;
	}
	public Float getOddsHadHome() {
		return oddsHadHome;
	}
	public Float getOddsHadDraw() {
		return oddsHadDraw;
	}
	public Float getOddsHadAway() {
		return oddsHadAway;
	}
	public Float getOddsHandicapLine() {
		return oddsHandicapLine;
	}
	public Float getOddsHandicapHome() {
		return oddsHandicapHome;
	}
	public Float getOddsHandicapAway() {
		return oddsHandicapAway;
	}
	public Float getOddsHiLoLine() {
		return oddsHiLoLine;
	}
	public Float getOddsHiLoHigh() {
		return oddsHiLoHigh;
	}
	public Float getOddsHiLoLow() {
		return oddsHiLoLow;
	}
	public Float getOddsCornerHiLoLine() {
		return oddsCornerHiLoLine;
	}
	public Float getOddsCornerHiLoHigh() {
		return oddsCornerHiLoHigh;
	}
	public Float getOddsCornerHiLoLow() {
		return oddsCornerHiLoLow;
	}
	public ArrayList<RecentForm> getRfHome() {
		return rfHome;
	}
	public ArrayList<RecentForm> getRfAway() {
		return rfAway;
	}
	public String getResult() {
		return result;
	}
	public Integer getResultHomeGoal() {
		return resultHomeGoal;
	}
	public Integer getResultAwayGoal() {
		return resultAwayGoal;
	}
	public Integer getResultTotalGoal() {
		return resultTotalGoal;
	}
	public Integer getResultHad() {
		return resultHad;
	}
	public Float getResultHdcHomeRoi() {
		return resultHdcHomeRoi;
	}
	public Float getResultHdcAwayRoi() {
		return resultHdcAwayRoi;
	}
	public Integer getResultCorner() {
		return resultCorner;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}
	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public void setMatchTypeEn(String matchTypeEn) {
		this.matchTypeEn = matchTypeEn;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public void setAwayName(String awayName) {
		this.awayName = awayName;
	}
	public void setHomeNameEn(String homeNameEn) {
		this.homeNameEn = homeNameEn;
	}
	public void setAwayNameEn(String awayNameEn) {
		this.awayNameEn = awayNameEn;
	}
	public void setHomeLRank(Integer homeLRank) {
		this.homeLRank = homeLRank;
	}
	public void setAwayLRank(Integer awayLRank) {
		this.awayLRank = awayLRank;
	}
	public void setOddsTime(Date oddsTime) {
		this.oddsTime = oddsTime;
	}
	public void setOddsHadHome(Float oddsHadHome) {
		this.oddsHadHome = oddsHadHome;
	}
	public void setOddsHadDraw(Float oddsHadDraw) {
		this.oddsHadDraw = oddsHadDraw;
	}
	public void setOddsHadAway(Float oddsHadAway) {
		this.oddsHadAway = oddsHadAway;
	}
	public void setOddsHandicapLine(Float oddsHandicapLine) {
		this.oddsHandicapLine = oddsHandicapLine;
	}
	public void setOddsHandicapHome(Float oddsHandicapHome) {
		this.oddsHandicapHome = oddsHandicapHome;
	}
	public void setOddsHandicapAway(Float oddsHandicapAway) {
		this.oddsHandicapAway = oddsHandicapAway;
	}
	public void setOddsHiLoLine(Float oddsHiLoLine) {
		this.oddsHiLoLine = oddsHiLoLine;
	}
	public void setOddsHiLoHigh(Float oddsHiLoHigh) {
		this.oddsHiLoHigh = oddsHiLoHigh;
	}
	public void setOddsHiLoLow(Float oddsHiLoLow) {
		this.oddsHiLoLow = oddsHiLoLow;
	}
	public void setOddsCornerHiLoLine(Float oddsCornerHiLoLine) {
		this.oddsCornerHiLoLine = oddsCornerHiLoLine;
	}
	public void setOddsCornerHiLoHigh(Float oddsCornerHiLoHigh) {
		this.oddsCornerHiLoHigh = oddsCornerHiLoHigh;
	}
	public void setOddsCornerHiLoLow(Float oddsCornerHiLoLow) {
		this.oddsCornerHiLoLow = oddsCornerHiLoLow;
	}
	public void setRfHome(ArrayList<RecentForm> rfHome) {
		this.rfHome = rfHome;
	}
	public void setRfAway(ArrayList<RecentForm> rfAway) {
		this.rfAway = rfAway;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setResultHomeGoal(Integer resultHomeGoal) {
		this.resultHomeGoal = resultHomeGoal;
	}
	public void setResultAwayGoal(Integer resultAwayGoal) {
		this.resultAwayGoal = resultAwayGoal;
	}
	public void setResultTotalGoal(Integer resultTotalGoal) {
		this.resultTotalGoal = resultTotalGoal;
	}
	public void setResultHad(Integer resultHad) {
		this.resultHad = resultHad;
	}
	public void setResultHdcHomeRoi(Float resultHdcHomeRoi) {
		this.resultHdcHomeRoi = resultHdcHomeRoi;
	}
	public void setResultHdcAwayRoi(Float resultHdcAwayRoi) {
		this.resultHdcAwayRoi = resultHdcAwayRoi;
	}
	public void setResultCorner(Integer resultCorner) {
		this.resultCorner = resultCorner;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
}
