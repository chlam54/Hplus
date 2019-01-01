package com.app.intf;

import java.util.List;

import com.app.model.Match;

public interface MatchDao {
	public static final String table = "match";
	
	void save(Match m);

	Match get(String id);
	
	List<Match> list(String sql, Object[] args);

	void updateResult(Match m);

	List<Match> updateResultList();

}
