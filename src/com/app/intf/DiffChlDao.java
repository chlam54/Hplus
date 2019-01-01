package com.app.intf;

import com.app.model.DiffChl;

public interface DiffChlDao {
public static final String table = "diffchl";
	
	void save(DiffChl m);

	DiffChl getLatest(String id);
}
