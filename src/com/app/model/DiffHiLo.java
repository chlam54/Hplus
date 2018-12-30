package com.app.model;

import java.sql.Timestamp;

import com.app.util.MathUtil;

public class DiffHiLo {
	private String id;
	private String bookmaker;
	private Timestamp oddsTime;
	private Float line, oddsHi, oddsLo;
	public DiffHiLo() {}
	
	public DiffHiLo(String id, String bookmaker, Timestamp oddsTime, Float line, Float oddsHi, Float oddsLo) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
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
		DiffHiLo od = (DiffHiLo)obj;
		
		boolean isSame = od.getId().equals(this.id) &&
				od.getBookmaker().equals(this.bookmaker) &&
				MathUtil.compareFloat(od.getOddsHi(), this.oddsHi)==0 &&
				MathUtil.compareFloat(od.getOddsLo(), this.oddsLo)==0 &&
				MathUtil.compareFloat(od.getLine(), this.line)==0;
		return isSame;
	}

	@Override
	public String toString() {
		return "DiffHiLo [id=" + id + ", bookmaker=" + bookmaker + ", oddsTime=" + oddsTime + ", line=" + line
				+ ", oddsHi=" + oddsHi + ", oddsLo=" + oddsLo + "]";
	}
}
