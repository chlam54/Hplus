package com.app.model;

import java.sql.Timestamp;

import com.app.util.MathUtil;

public class DiffHad {
	private String id;
	private String bookmaker;
	private Timestamp oddsTime;
	private Float oddsHome, oddsAway, oddsDraw;
	public DiffHad() {}
	
	public DiffHad(String id, String bookmaker, Timestamp oddsTime, Float oddsHome, Float oddsAway, Float oddsDraw) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
		this.oddsTime = oddsTime;
		this.oddsHome = oddsHome;
		this.oddsAway = oddsAway;
		this.oddsDraw = oddsDraw;
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

	public Float getOddsDraw() {
		return oddsDraw;
	}

	public void setOddsDraw(Float oddsDraw) {
		this.oddsDraw = oddsDraw;
	}

	@Override
	public String toString() {
		return "DiffHad [id=" + id + ", bookmaker=" + bookmaker + ", oddsTime=" + oddsTime + ", oddsHome=" + oddsHome
				+ ", oddsAway=" + oddsAway + ", oddsDraw=" + oddsDraw + "]";
	}

	@Override
	public boolean equals(Object obj) {
		DiffHad od = (DiffHad)obj;
		
		boolean isSame = od.getId().equals(this.id) &&
				od.getBookmaker().equals(this.bookmaker) &&
				MathUtil.compareFloat(od.getOddsAway(), this.oddsAway)==0 &&
				MathUtil.compareFloat(od.getOddsHome(), this.oddsHome)==0 &&
				MathUtil.compareFloat(od.getOddsDraw(), this.oddsDraw)==0;
		return isSame;
	}
}