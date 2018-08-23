package com.app.scraper;

public class InfoHdc {
	private Float oddsHandicapLine;
	private Float oddsHandicapHome;
	private Float oddsHandicapAway;
	@Override
	public String toString() {
		return "InfoHdc [oddsHandicapLine=" + oddsHandicapLine + ", oddsHandicapHome=" + oddsHandicapHome
				+ ", oddsHandicapAway=" + oddsHandicapAway + "]";
	}
	public InfoHdc(Float oddsHandicapLine, Float oddsHandicapHome, Float oddsHandicapAway) {
		super();
		this.oddsHandicapLine = oddsHandicapLine;
		this.oddsHandicapHome = oddsHandicapHome;
		this.oddsHandicapAway = oddsHandicapAway;
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
}
