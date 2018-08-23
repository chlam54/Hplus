package com.app.dao;

import java.util.List;

import com.app.model.Match;

public interface MatchDao {

	void save(Match m);

	Match get(String id);

	void updateResult(Match m);

	List<Match> updateResultList();

	void deleteResult(Match m);

}
