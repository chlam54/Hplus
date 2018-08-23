package com.app.scraper;

public class InfoResult {
	public InfoResult(Integer homeGoal, Integer awayGoal, Integer corner, String result) {
		super();
		this.homeGoal = homeGoal;
		this.awayGoal = awayGoal;
		this.corner = corner;
		this.result = result;
	}
	public Integer getHomeGoal() {
		return homeGoal;
	}
	public Integer getAwayGoal() {
		return awayGoal;
	}
	public Integer getCorner() {
		return corner;
	}
	public String getResult() {
		return result;
	}
	@Override
	public String toString() {
		return "InfoResult [homeGoal=" + homeGoal + ", awayGoal=" + awayGoal + ", corner=" + corner + ", result="
				+ result + "]";
	}
	private Integer homeGoal, awayGoal, corner;
	private String result;
	
}
