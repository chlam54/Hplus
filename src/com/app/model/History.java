package com.app.model;

public class History {
	private String id;
	private int seq;
	private String team;
	private String game;
	private String date;
	private String hisTeam;
	private String agst;
	private String result;
	private Integer goal;
	private Integer oppGoal;
	private Integer wdl;
	private Float hdcLine;
	private Float hdcRoi;
	private Float hhaLine;
	private Integer corner;
	public History() {}
	public History(String id, int seq, String team, String game, String date, String hisTeam, String agst,
			String result, Integer goal, Integer oppGoal, Integer wdl, Float hdcLine, Float hdcRoi, Float hhaLine,
			Integer corner) {
		super();
		this.id = id;
		this.seq = seq;
		this.team = team;
		this.game = game;
		this.date = date;
		this.hisTeam = hisTeam;
		this.agst = agst;
		this.result = result;
		this.goal = goal;
		this.oppGoal = oppGoal;
		this.wdl = wdl;
		this.hdcLine = hdcLine;
		this.hdcRoi = hdcRoi;
		this.hhaLine = hhaLine;
		this.corner = corner;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", seq=" + seq + ", team=" + team + ", game=" + game + ", date=" + date
				+ ", hisTeam=" + hisTeam + ", agst=" + agst + ", result=" + result + ", goal=" + goal + ", oppGoal="
				+ oppGoal + ", wdl=" + wdl + ", hdcLine=" + hdcLine + ", hdcRoi=" + hdcRoi + ", hhaLine=" + hhaLine
				+ ", corner=" + corner + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getGame() {
		return game;
	}
	public void setGame(String game) {
		this.game = game;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHisTeam() {
		return hisTeam;
	}
	public void setHisTeam(String hisTeam) {
		this.hisTeam = hisTeam;
	}
	public String getAgst() {
		return agst;
	}
	public void setAgst(String agst) {
		this.agst = agst;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getGoal() {
		return goal;
	}
	public void setGoal(Integer goal) {
		this.goal = goal;
	}
	public Integer getOppGoal() {
		return oppGoal;
	}
	public void setOppGoal(Integer oppGoal) {
		this.oppGoal = oppGoal;
	}
	public Integer getWdl() {
		return wdl;
	}
	public void setWdl(Integer wdl) {
		this.wdl = wdl;
	}
	public Float getHdcLine() {
		return hdcLine;
	}
	public void setHdcLine(Float hdcLine) {
		this.hdcLine = hdcLine;
	}
	public Float getHdcRoi() {
		return hdcRoi;
	}
	public void setHdcRoi(Float hdcRoi) {
		this.hdcRoi = hdcRoi;
	}
	public Float getHhaLine() {
		return hhaLine;
	}
	public void setHhaLine(Float hhaLine) {
		this.hhaLine = hhaLine;
	}
	public Integer getCorner() {
		return corner;
	}
	public void setCorner(Integer corner) {
		this.corner = corner;
	}

}
