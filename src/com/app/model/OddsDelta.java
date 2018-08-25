package com.app.model;

import java.util.Date;

public class OddsDelta {
	private String id;
	private String bookmaker;
	private String bid;
	private Date oddsTime;
	private Float oddsHandicapLine, oddsHandicapHome, oddsHandicapAway;
	public OddsDelta() {}
	public OddsDelta(String id, String bookmaker, String bid, Date oddsTime, Float oddsHandicapLine,
			Float oddsHandicapHome, Float oddsHandicapAway) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
		this.bid = bid;
		this.oddsTime = oddsTime;
		this.oddsHandicapLine = oddsHandicapLine;
		this.oddsHandicapHome = oddsHandicapHome;
		this.oddsHandicapAway = oddsHandicapAway;
	}
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
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Date getOddsTime() {
		return oddsTime;
	}
	public void setOddsTime(Date oddsTime) {
		this.oddsTime = oddsTime;
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
	@Override
	public String toString() {
		return "OddsDelta [id=" + id + ", bookmaker=" + bookmaker + ", bid=" + bid + ", oddsTime=" + oddsTime
				+ ", oddsHandicapLine=" + oddsHandicapLine + ", oddsHandicapHome=" + oddsHandicapHome
				+ ", oddsHandicapAway=" + oddsHandicapAway + "]";
	}
	@Override
	public boolean equals(Object obj) {
		OddsDelta od = (OddsDelta)obj;
		boolean isSame = od.getId()==this.id &&
				od.getBookmaker()==this.bookmaker &&
				od.getBid()==this.bid &&
				od.getOddsHandicapAway()==this.oddsHandicapAway &&
				od.getOddsHandicapHome()==this.oddsHandicapHome &&
				od.getOddsHandicapLine()==this.oddsHandicapLine;
		return isSame;
	}
}