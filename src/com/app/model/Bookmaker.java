package com.app.model;

public class Bookmaker {
	private String id;
	private String bookmaker;
	private String bid;
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
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public Bookmaker(String id, String bookmaker, String bid) {
		super();
		this.id = id;
		this.bookmaker = bookmaker;
		this.bid = bid;
	}
}
