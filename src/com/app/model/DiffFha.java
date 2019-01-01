package com.app.model;

import java.sql.Timestamp;

import com.app.util.MathUtil;

public class DiffFha {
	private String id;
	private Timestamp oddsTime;
	private Float oddsHome, oddsAway, oddsDraw;
	public DiffFha() {}
	
	public DiffFha(String id, Timestamp oddsTime, Float oddsHome, Float oddsAway, Float oddsDraw) {
		super();
		this.id = id;
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
		return "DiffFha [id=" + id + ", oddsTime=" + oddsTime + ", oddsHome=" + oddsHome + ", oddsAway=" + oddsAway
				+ ", oddsDraw=" + oddsDraw + "]";
	}

	@Override
	public boolean equals(Object obj) {
		DiffFha od = (DiffFha)obj;
		
		boolean isSame = od.getId().equals(this.id) &&
				MathUtil.compareFloat(od.getOddsAway(), this.oddsAway)==0 &&
				MathUtil.compareFloat(od.getOddsHome(), this.oddsHome)==0 &&
				MathUtil.compareFloat(od.getOddsDraw(), this.oddsDraw)==0;
		return isSame;
	}
}