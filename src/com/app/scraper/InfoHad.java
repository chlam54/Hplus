package com.app.scraper;

import java.sql.Timestamp;

public class InfoHad {
	private String matchNum;
	private String matchDate;
	private Timestamp matchTime;
	private String matchType;
	private String matchTypeEn;
	private String homeName;
	private String homeNameEn;
	private String awayName;
	private String awayNameEn;
	private Float oddsHadHome;
	private Float oddsHadDraw;
	private Float oddsHadAway;
	
	public InfoHad(String matchNum, String matchDate, Timestamp matchTime, String matchType, String matchTypeEn, String homeName,
			String homeNameEn, String awayName, String awayNameEn, Float oddsHadHome, Float oddsHadDraw,
			Float oddsHadAway) {
		super();
		this.matchNum = matchNum;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.matchType = matchType;
		this.matchTypeEn = matchTypeEn;
		this.homeName = homeName;
		this.homeNameEn = homeNameEn;
		this.awayName = awayName;
		this.awayNameEn = awayNameEn;
		this.oddsHadHome = oddsHadHome;
		this.oddsHadDraw = oddsHadDraw;
		this.oddsHadAway = oddsHadAway;
	}
	
	@Override
	public String toString() {
		return "InfoHad [matchNum=" + matchNum + ", matchDate=" + matchDate + ", matchTime=" + matchTime
				+ ", matchType=" + matchType + ", matchTypeEn=" + matchTypeEn + ", homeName=" + homeName
				+ ", homeNameEn=" + homeNameEn + ", awayName=" + awayName + ", awayNameEn=" + awayNameEn
				+ ", oddsHadHome=" + oddsHadHome + ", oddsHadDraw=" + oddsHadDraw + ", oddsHadAway=" + oddsHadAway
				+ "]";
	}

	public String getMatchNum() {
		return matchNum;
	}
	public Timestamp getMatchTime() {
		return matchTime;
	}
	public String getMatchType() {
		return matchType;
	}
	public String getHomeName() {
		return homeName;
	}
	public String getAwayName() {
		return awayName;
	}
	public String getMatchTypeEn() {
		return matchTypeEn;
	}
	public String getHomeNameEn() {
		return homeNameEn;
	}
	public String getAwayNameEn() {
		return awayNameEn;
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
	public String getMatchDate() {
		return matchDate;
	}

}
