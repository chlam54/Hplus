package com.app.intf;

import com.app.model.DiffHiLo;

public interface DiffHilDao {
	public static final String table = "data.diffhilo";
	
	void save(DiffHiLo m);

	DiffHiLo getLatest(String id);

}
