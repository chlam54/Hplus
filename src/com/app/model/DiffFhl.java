package com.app.model;

import java.sql.Timestamp;

import com.app.util.MathUtil;

public class DiffFhl {
	private String id;
	private Timestamp oddsTime;
	private Float line, oddsHi, oddsLo;
	public DiffFhl() {}
	
	public DiffFhl(String id, Timestamp oddsTime, Float line, Float oddsHi, Float oddsLo) {
		super();
		this.id = id;
		this.oddsTime = oddsTime;
		this.line = line;
		this.oddsHi = oddsHi;
		this.oddsLo = oddsLo;
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

	public Float getLine() {
		return line;
	}

	public void setLine(Float line) {
		this.line = line;
	}

	public Float getOddsHi() {
		return oddsHi;
	}

	public void setOddsHi(Float oddsHi) {
		this.oddsHi = oddsHi;
	}

	public Float getOddsLo() {
		return oddsLo;
	}

	public void setOddsLo(Float oddsLo) {
		this.oddsLo = oddsLo;
	}

	@Override
	public boolean equals(Object obj) {
		DiffFhl od = (DiffFhl)obj;
		
		boolean isSame = od.getId().equals(this.id) &&
				MathUtil.compareFloat(od.getOddsHi(), this.oddsHi)==0 &&
				MathUtil.compareFloat(od.getOddsLo(), this.oddsLo)==0 &&
				MathUtil.compareFloat(od.getLine(), this.line)==0;
		return isSame;
	}

	@Override
	public String toString() {
		return "DiffFhl [id=" + id + ", oddsTime=" + oddsTime + ", line=" + line + ", oddsHi=" + oddsHi + ", oddsLo="
				+ oddsLo + "]";
	}
}
