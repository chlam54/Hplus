package com.app.intf;

import com.app.model.DiffHha;

public interface DiffHhaDao {
	public static final String table = "diffhha";
	public void save(DiffHha od) ;
	DiffHha getLatest(String id);
}
