package com.app.scraper;

public class InfoHil {
	
	private Float oddsHiLoLine;
	private Float oddsHiLoHigh;
	private Float oddsHiLoLow;
	
	public InfoHil(Float oddsHiLoLine, Float oddsHiLoHigh, Float oddsHiLoLow) {
		super();
		this.oddsHiLoLine = oddsHiLoLine;
		this.oddsHiLoHigh = oddsHiLoHigh;
		this.oddsHiLoLow = oddsHiLoLow;
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

	@Override
	public String toString() {
		return "InfoHil [oddsHiLoLine=" + oddsHiLoLine + ", oddsHiLoHigh=" + oddsHiLoHigh + ", oddsHiLoLow="
				+ oddsHiLoLow + "]";
	}
	
}
