package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.intf.DiffHadDao;
import com.app.model.DiffHad;
import com.app.scraper.MatchScraper;
import com.app.util.Util;

public class DiffHadDaoImpl extends AbstractDaoImpl implements DiffHadDao {
	private final static Logger logger = Util.getLogger(DiffHadDaoImpl.class);
	
	public DiffHadDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffHad od) {
		String sql = "INSERT INTO "+table+" (id, bookmaker, oddsTime, "
				+ "oddsHome, oddsAway, oddsDraw) VALUES ("
				+ "?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getBookmaker(), od.getOddsTime(),
				od.getOddsHome(), od.getOddsAway(), od.getOddsDraw()});
	}
	
	private List<DiffHad> list(String sql, Object[] args){
		return (List<DiffHad>)this.jdbcTemplate.query(sql, args, new RowMapperDiffHad());
	}
	
	public DiffHad getLatest(String id) {
		String sql = "SELECT id, bookmaker, oddsTime, "
				+ "oddsHome, oddsAway, oddsDraw "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffHad result = null;
		try {
			result = (DiffHad)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffHad());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
