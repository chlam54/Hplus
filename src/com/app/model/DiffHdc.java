package com.app.model;

import java.sql.Timestamp;

import com.app.util.MathUtil;

public class DiffHdc {
	private String id;
	private String bookmaker;
	private Timestamp oddsTime;
	private Float line, oddsHome, oddsAway;
	public DiffHdc() {}
	
	public DiffHdc(String id, String bookmaker, Timestamp oddsTime, Float line, Float oddsHome, Float oddsAway) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
		this.oddsTime = oddsTime;
		this.line = line;
		this.oddsHome = oddsHome;
		this.oddsAway = oddsAway;
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

	public Timestamp getOddsTime() {
		return oddsTime;
	}

	public void setOddsTime(Timestamp oddsTime) {
		this.oddsTime = oddsTime;
	}

	public Float getLine() {
		return line;
	}

	public void setLine(Float line) {
		this.line = line;
	}

	public Float getOddsHome() {
		return oddsHome;
	}

	public void setOddsHome(Float oddsHome) {
		this.oddsHome = oddsHome;
	}

	public Float getOddsAway() {
		return oddsAway;
	}

	public void setOddsAway(Float oddsAway) {
		this.oddsAway = oddsAway;
	}

	@Override
	public boolean equals(Object obj) {
		DiffHdc od = (DiffHdc)obj;
		
		boolean isSame = od.getId().equals(this.id) &&
				od.getBookmaker().equals(this.bookmaker) &&
				MathUtil.compareFloat(od.getOddsAway(), this.oddsAway)==0 &&
				MathUtil.compareFloat(od.getOddsHome(), this.oddsHome)==0 &&
				MathUtil.compareFloat(od.getLine(), this.line)==0;
		return isSame;
	}

	@Override
	public String toString() {
		return "DiffHdc [id=" + id + ", bookmaker=" + bookmaker + ", oddsTime=" + oddsTime + ", line=" + line
				+ ", oddsHome=" + oddsHome + ", oddsAway=" + oddsAway + "]";
	}
}
