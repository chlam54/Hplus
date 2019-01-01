package com.app.scraper;

public class InfoResult {
	private Integer halfTimeHomeGoal, halfTimeAwayGoal,
		fullTimeHomeGoal, fullTimeAwayGoal, corner;

	public InfoResult(Integer halfTimeHomeGoal, Integer halfTimeAwayGoal, Integer fullTimeHomeGoal,
			Integer fullTimeAwayGoal, Integer corner) {
		super();
		this.halfTimeHomeGoal = halfTimeHomeGoal;
		this.halfTimeAwayGoal = halfTimeAwayGoal;
		this.fullTimeHomeGoal = fullTimeHomeGoal;
		this.fullTimeAwayGoal = fullTimeAwayGoal;
		this.corner = corner;
	}

	public Integer getHalfTimeHomeGoal() {
		return halfTimeHomeGoal;
	}

	public void setHalfTimeHomeGoal(Integer halfTimeHomeGoal) {
		this.halfTimeHomeGoal = halfTimeHomeGoal;
	}

	public Integer getHalfTimeAwayGoal() {
		return halfTimeAwayGoal;
	}

	public void setHalfTimeAwayGoal(Integer halfTimeAwayGoal) {
		this.halfTimeAwayGoal = halfTimeAwayGoal;
	}

	public Integer getFullTimeHomeGoal() {
		return fullTimeHomeGoal;
	}

	public void setFullTimeHomeGoal(Integer fullTimeHomeGoal) {
		this.fullTimeHomeGoal = fullTimeHomeGoal;
	}

	public Integer getFullTimeAwayGoal() {
		return fullTimeAwayGoal;
	}

	public void setFullTimeAwayGoal(Integer fullTimeAwayGoal) {
		this.fullTimeAwayGoal = fullTimeAwayGoal;
	}

	public Integer getCorner() {
		return corner;
	}

	public void setCorner(Integer corner) {
		this.corner = corner;
	}
	
}