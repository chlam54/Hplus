package com.app.intf;

import com.app.model.DiffFha;

public interface DiffFhaDao {
	public static final String table = "difffha";
	public void save(DiffFha od) ;
	DiffFha getLatest(String id);
}
