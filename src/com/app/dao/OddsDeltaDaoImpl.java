package com.app.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.app.model.OddsDelta;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class OddsDeltaDaoImpl extends MatchDaoImpl implements OddsDeltaDao {
	private static final String table = "data.oddsDelta";
	public OddsDeltaDaoImpl() {
		super();
	}
	
	@Override
	public void save(OddsDelta od) {
		String sql = "INSERT INTO "+table+" (id, bookmaker, bid, oddsTime, "
				+ "oddsHandicapLine, oddsHandicapHome, oddsHandicapAway) VALUES ("
				+ "?, ?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getBookmaker(), od.getBid(), od.getOddsTime(),
				od.getOddsHandicapLine(), od.getOddsHandicapHome(), od.getOddsHandicapAway()});
	}
	
	private List<OddsDelta> list(String sql, Object[] args){
		return (List<OddsDelta>)this.jdbcTemplate.query(sql, args, new OddsDeltaRowMapper());
	}
	
	public OddsDelta getLatest(String id) {
		String sql = "SELECT id, bookmaker, bid, max(oddsTime) as oddsTime, "
				+ "oddsHandicapLine, oddsHandicapHome, oddsHandicapAway "
				+ "FROM data.oddsdelta where id = ?;";
		return (OddsDelta)this.jdbcTemplate.queryForObject(sql, new Object[] {id}, 
				new OddsDeltaRowMapper());
	}
}
