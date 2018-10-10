package com.app.dao;

import com.app.model.OddsDelta;

public interface OddsDeltaDao {
	public static final String table = "data.oddsDelta";
	
	void save(OddsDelta m);

	OddsDelta getLatest(String id);

}
