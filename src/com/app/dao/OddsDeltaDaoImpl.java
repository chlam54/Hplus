package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.model.OddsDelta;
import com.app.scraper.MatchScraper;
import com.app.util.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class OddsDeltaDaoImpl extends AbstractDaoImpl implements OddsDeltaDao {
	private final static Logger logger = Util.getLogger(OddsDeltaDaoImpl.class);
	
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
		String sql = "SELECT id, bookmaker, bid, oddsTime, "
				+ "oddsHandicapLine, oddsHandicapHome, oddsHandicapAway "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		OddsDelta result = null;
		try {
			result = (OddsDelta)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new OddsDeltaRowMapper());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
