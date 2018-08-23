package com.app.model;

import java.util.Date;

public class OddsDelta {
	private String id;
	private String bookmaker;
	private String bid;
	private Date oddsTime;
	private Float oddsHadHome, oddsHadDraw, oddsHadAway;
	private Float oddsHandicapLine, oddsHandicapHome, oddsHandicapAway;
	private Float oddsHiLoLine, oddsHiLoHigh, oddsHiLoLow;
	private Float oddsCornerHiLoLine, oddsCornerHiLoHigh, oddsCornerHiLoLow;
	public OddsDelta() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookmaker() {
		return bookmaker;
	}
	public void setBookmaker(String bookmaker) {
		this.bookmaker = bookmaker;
	}
	public Date getOddsTime() {
		return oddsTime;
	}
	public void setOddsTime(Date oddsTime) {
		this.oddsTime = oddsTime;
	}
	public Float getOddsHadHome() {
		return oddsHadHome;
	}
	public void setOddsHadHome(Float oddsHadHome) {
		this.oddsHadHome = oddsHadHome;
	}
	public Float getOddsHadDraw() {
		return oddsHadDraw;
	}
	public void setOddsHadDraw(Float oddsHadDraw) {
		this.oddsHadDraw = oddsHadDraw;
	}
	public Float getOddsHadAway() {
		return oddsHadAway;
	}
	public void setOddsHadAway(Float oddsHadAway) {
		this.oddsHadAway = oddsHadAway;
	}
	public Float getOddsHandicapLine() {
		return oddsHandicapLine;
	}
	public void setOddsHandicapLine(Float oddsHandicapLine) {
		this.oddsHandicapLine = oddsHandicapLine;
	}
	public Float getOddsHandicapHome() {
		return oddsHandicapHome;
	}
	public void setOddsHandicapHome(Float oddsHandicapHome) {
		this.oddsHandicapHome = oddsHandicapHome;
	}
	public Float getOddsHandicapAway() {
		return oddsHandicapAway;
	}
	public void setOddsHandicapAway(Float oddsHandicapAway) {
		this.oddsHandicapAway = oddsHandicapAway;
	}
	public Float getOddsHiLoLine() {
		return oddsHiLoLine;
	}
	public void setOddsHiLoLine(Float oddsHiLoLine) {
		this.oddsHiLoLine = oddsHiLoLine;
	}
	public Float getOddsHiLoHigh() {
		return oddsHiLoHigh;
	}
	public OddsDelta(String id, String bookmaker, String bid, Date oddsTime, Float oddsHadHome, Float oddsHadDraw,
			Float oddsHadAway, Float oddsHandicapLine, Float oddsHandicapHome, Float oddsHandicapAway,
			Float oddsHiLoLine, Float oddsHiLoHigh, Float oddsHiLoLow, Float oddsCornerHiLoLine,
			Float oddsCornerHiLoHigh, Float oddsCornerHiLoLow) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
		this.bid = bid;
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
	}
	@Override
	public String toString() {
		return "OddsDelta [id=" + id + ", bookmaker=" + bookmaker + ", bid=" + bid + ", oddsTime=" + oddsTime
				+ ", oddsHadHome=" + oddsHadHome + ", oddsHadDraw=" + oddsHadDraw + ", oddsHadAway=" + oddsHadAway
				+ ", oddsHandicapLine=" + oddsHandicapLine + ", oddsHandicapHome=" + oddsHandicapHome
				+ ", oddsHandicapAway=" + oddsHandicapAway + ", oddsHiLoLine=" + oddsHiLoLine + ", oddsHiLoHigh="
				+ oddsHiLoHigh + ", oddsHiLoLow=" + oddsHiLoLow + ", oddsCornerHiLoLine=" + oddsCornerHiLoLine
				+ ", oddsCornerHiLoHigh=" + oddsCornerHiLoHigh + ", oddsCornerHiLoLow=" + oddsCornerHiLoLow + "]";
	}
	public void setOddsHiLoHigh(Float oddsHiLoHigh) {
		this.oddsHiLoHigh = oddsHiLoHigh;
	}
	public Float getOddsHiLoLow() {
		return oddsHiLoLow;
	}
	public void setOddsHiLoLow(Float oddsHiLoLow) {
		this.oddsHiLoLow = oddsHiLoLow;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Float getOddsCornerHiLoLine() {
		return oddsCornerHiLoLine;
	}
	public void setOddsCornerHiLoLine(Float oddsCornerHiLoLine) {
		this.oddsCornerHiLoLine = oddsCornerHiLoLine;
	}
	public Float getOddsCornerHiLoHigh() {
		return oddsCornerHiLoHigh;
	}
	public void setOddsCornerHiLoHigh(Float oddsCornerHiLoHigh) {
		this.oddsCornerHiLoHigh = oddsCornerHiLoHigh;
	}
	public Float getOddsCornerHiLoLow() {
		return oddsCornerHiLoLow;
	}
	public void setOddsCornerHiLoLow(Float oddsCornerHiLoLow) {
		this.oddsCornerHiLoLow = oddsCornerHiLoLow;
	}

	
}