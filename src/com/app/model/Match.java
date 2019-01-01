package com.app.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Match {
	private String id;
	
	private String matchNum;
	private String matchDate;
	private Timestamp matchTime;
	private String matchType;
	private String matchTypeEn;
	
	private String homeName;
	private String awayName;
	private String homeNameEn;
	private String awayNameEn;
	private Integer homeLRank;
	private Integer awayLRank;
	
	private Integer resultHtHg;
	private Integer resultHtAg;
	private Integer resultFtHg;
	private Integer resultFtAg;
	
	private Integer resultCorner;
	public Match() {}
	public Match(String id, String matchNum, String matchDate, Timestamp matchTime, String matchType,
			String matchTypeEn, String homeName, String awayName, String homeNameEn, String awayNameEn,
			Integer homeLRank, Integer awayLRank, Integer resultHtHg, Integer resultHtAg, Integer resultFtHg,
			Integer resultFtAg, Integer resultCorner) {
		super();
		this.id = id;
		this.matchNum = matchNum;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.matchType = matchType;
		this.matchTypeEn = matchTypeEn;
		this.homeName = homeName;
		this.awayName = awayName;
		this.homeNameEn = homeNameEn;
		this.awayNameEn = awayNameEn;
		this.homeLRank = homeLRank;
		this.awayLRank = awayLRank;
		this.resultHtHg = resultHtHg;
		this.resultHtAg = resultHtAg;
		this.resultFtHg = resultFtHg;
		this.resultFtAg = resultFtAg;
		this.resultCorner = resultCorner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(String matchNum) {
		this.matchNum = matchNum;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
	}
	public Timestamp getMatchTime() {
		return matchTime;
	}
	public void setMatchTime(Timestamp matchTime) {
		this.matchTime = matchTime;
	}
	public String getMatchType() {
		return matchType;
	}
	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}
	public String getMatchTypeEn() {
		return matchTypeEn;
	}
	public void setMatchTypeEn(String matchTypeEn) {
		this.matchTypeEn = matchTypeEn;
	}
	public String getHomeName() {
		return homeName;
	}
	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}
	public String getAwayName() {
		return awayName;
	}
	public void setAwayName(String awayName) {
		this.awayName = awayName;
	}
	public String getHomeNameEn() {
		return homeNameEn;
	}
	public void setHomeNameEn(String homeNameEn) {
		this.homeNameEn = homeNameEn;
	}
	public String getAwayNameEn() {
		return awayNameEn;
	}
	public void setAwayNameEn(String awayNameEn) {
		this.awayNameEn = awayNameEn;
	}
	public Integer getHomeLRank() {
		return homeLRank;
	}
	public void setHomeLRank(Integer homeLRank) {
		this.homeLRank = homeLRank;
	}
	public Integer getAwayLRank() {
		return awayLRank;
	}
	public void setAwayLRank(Integer awayLRank) {
		this.awayLRank = awayLRank;
	}
	public Integer getResultHtHg() {
		return resultHtHg;
	}
	public void setResultHtHg(Integer resultHtHg) {
		this.resultHtHg = resultHtHg;
	}
	public Integer getResultHtAg() {
		return resultHtAg;
	}
	public void setResultHtAg(Integer resultHtAg) {
		this.resultHtAg = resultHtAg;
	}
	public Integer getResultFtHg() {
		return resultFtHg;
	}
	public void setResultFtHg(Integer resultFtHg) {
		this.resultFtHg = resultFtHg;
	}
	public Integer getResultFtAg() {
		return resultFtAg;
	}
	public void setResultFtAg(Integer resultFtAg) {
		this.resultFtAg = resultFtAg;
	}
	public Integer getResultCorner() {
		return resultCorner;
	}
	public void setResultCorner(Integer resultCorner) {
		this.resultCorner = resultCorner;
	}

}
