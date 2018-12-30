package com.app.intf;

import com.app.model.DiffHdc;

public interface DiffHdcDao {
	public static final String table = "data.diffhdc";
	
	void save(DiffHdc m);

	DiffHdc getLatest(String id);

}
