package com.app.model;

public class RecentForm {
	private String type;
	private String date;
	private String role;
	private String agst;
	private String result;
	private Integer goal;
	private Integer oppGoal;
	private Integer wdl;
	private Float hdcLine;
	private Float hdcRoi;
	private Float hhadLine;
	private Integer corner;
	
	public RecentForm(String type, String date, String role, String agst, String result, Integer goal, Integer oppGoal,
			Integer wdl, Float hdcLine, Float hdcRoi, Float hhadLine, Integer corner) {
		super();
		this.type = type;
		this.date = date;
		this.role = role;
		this.agst = agst;
		this.result = result;
		this.goal = goal;
		this.oppGoal = oppGoal;
		this.wdl = wdl;
		this.hdcLine = hdcLine;
		this.hdcRoi = hdcRoi;
		this.hhadLine = hhadLine;
		this.corner = corner;
	}

	public String getType() {
		return type;
	}

	public String getDate() {
		return date;
	}

	public String getRole() {
		return role;
	}

	public String getAgst() {
		return agst;
	}

	public String getResult() {
		return result;
	}

	public Integer getGoal() {
		return goal;
	}

	public Integer getOppGoal() {
		return oppGoal;
	}

	public Integer getWdl() {
		return wdl;
	}

	public Float getHdcLine() {
		return hdcLine;
	}

	public Float getHdcRoi() {
		return hdcRoi;
	}

	public Float getHhadLine() {
		return hhadLine;
	}

	public Integer getCorner() {
		return corner;
	}

	@Override
	public String toString() {
		return "RecentForm [type=" + type + ", date=" + date + ", role=" + role + ", agst=" + agst + ", result="
				+ result + ", goal=" + goal + ", oppGoal=" + oppGoal + ", wdl=" + wdl + ", hdcLine=" + hdcLine
				+ ", hdcRoi=" + hdcRoi + ", hhadLine=" + hhadLine + ", corner=" + corner + "]";
	}
	
}
