package com.app.intf;

import com.app.model.DiffFhl;

public interface DiffFhlDao {
public static final String table = "difffhl";
	
	void save(DiffFhl m);

	DiffFhl getLatest(String id);
}
