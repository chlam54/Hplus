package com.app.scraper;

public class InfoChl {
	private Float oddsCornerHiLoLine;
	private Float oddsCornerHiLoHigh;
	private Float oddsCornerHiLoLow;
	public Float getOddsCornerHiLoLine() {
		return oddsCornerHiLoLine;
	}
	public Float getOddsCornerHiLoHigh() {
		return oddsCornerHiLoHigh;
	}
	public Float getOddsCornerHiLoLow() {
		return oddsCornerHiLoLow;
	}
	@Override
	public String toString() {
		return "InfoChl [oddsCornerHiLoLine=" + oddsCornerHiLoLine + ", oddsCornerHiLoHigh=" + oddsCornerHiLoHigh
				+ ", oddsCornerHiLoLow=" + oddsCornerHiLoLow + "]";
	}
	public InfoChl(Float oddsCornerHiLoLine, Float oddsCornerHiLoHigh, Float oddsCornerHiLoLow) {
		super();
		this.oddsCornerHiLoLine = oddsCornerHiLoLine;
		this.oddsCornerHiLoHigh = oddsCornerHiLoHigh;
		this.oddsCornerHiLoLow = oddsCornerHiLoLow;
	}
	
}
