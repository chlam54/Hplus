package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.intf.HistoryDao;
import com.app.model.History;
import com.app.util.Util;

public class HistoryDaoImpl extends AbstractDaoImpl implements HistoryDao {
	private final static Logger logger = Util.getLogger(HistoryDaoImpl.class);
	
	public HistoryDaoImpl() {
		super();
	}

	@Override
	public void save(History history) {
		String sql = "INSERT INTO "+table+" (id, seq, team, "
				+ "game, date, hisTeam, agst, result, "
				+ "goal, oppGoal, wdl, hdcLine, hdcRoi,hhaLine,corner) VALUES ("
				+ "?, ?, ?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,?,?)";
		this.jdbcTemplate.update(sql, new Object[] {
				history.getId(), history.getSeq(), history.getTeam(),
				history.getGame(), history.getDate(), history.getHisTeam(), history.getAgst(), history.getResult(),
				history.getGoal(), history.getOppGoal(), history.getWdl(), history.getHdcLine(), history.getHdcRoi(), history.getHhaLine(), history.getCorner()});
	}

	@Override
	public List<History> getHistory(String id, String team) {
		String sql = "select * from "+table+" where id=? and team=?";
		return (List<History>)jdbcTemplate.query(sql, new Object[] {id, team}, new RowMapperHistory());
	}
}
