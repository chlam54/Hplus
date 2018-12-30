package com.app.intf;

import com.app.model.DiffHad;

public interface DiffHadDao {
	public static final String table = "data.diffhad";
	
	void save(DiffHad m);

	DiffHad getLatest(String id);

}
