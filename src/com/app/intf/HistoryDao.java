package com.app.intf;

import java.util.List;

import com.app.model.History;

public interface HistoryDao {
	public static String table = "history";
	public void save(History history);
	public List<History> getHistory(String id, String team);
}
