package com.app.intf;

import com.app.model.DiffHil;

public interface DiffHilDao {
	public static final String table = "diffhil";
	
	void save(DiffHil m);

	DiffHil getLatest(String id);

}
