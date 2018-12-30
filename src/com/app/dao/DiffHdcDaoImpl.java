package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.intf.DiffHdcDao;
import com.app.model.DiffHdc;
import com.app.util.Util;

public class DiffHdcDaoImpl extends AbstractDaoImpl implements DiffHdcDao {
	private final static Logger logger = Util.getLogger(DiffHdcDaoImpl.class);
	
	public DiffHdcDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffHdc od) {
		String sql = "INSERT INTO "+table+" (id, bookmaker, oddsTime, "
				+ "line, oddsHome, oddsAway) VALUES ("
				+ "?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getBookmaker(), od.getOddsTime(),
				od.getLine(), od.getOddsHome(), od.getOddsAway()});
	}
	
	private List<DiffHdc> list(String sql, Object[] args){
		return (List<DiffHdc>)this.jdbcTemplate.query(sql, args, new RowMapperDiffHdc());
	}
	
	public DiffHdc getLatest(String id) {
		String sql = "SELECT id, bookmaker, bid, oddsTime, "
				+ "oddsHandicapLine, oddsHandicapHome, oddsHandicapAway "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffHdc result = null;
		try {
			result = (DiffHdc)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffHdc());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
