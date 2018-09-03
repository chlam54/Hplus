package com.app.dao;

import com.app.model.OddsDelta;

public interface OddsDeltaDao {
	
	void save(OddsDelta m);

	OddsDelta getLatest(String id);

}
