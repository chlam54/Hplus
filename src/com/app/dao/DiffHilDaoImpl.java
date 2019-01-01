package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.intf.DiffHilDao;
import com.app.model.DiffHil;
import com.app.util.Util;

public class DiffHilDaoImpl extends AbstractDaoImpl implements DiffHilDao {
	private final static Logger logger = Util.getLogger(DiffHilDaoImpl.class);
	
	public DiffHilDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffHil od) {
		String sql = "INSERT INTO "+table+" (id, bookmaker, oddsTime, "
				+ "line, oddsHi, oddsLo) VALUES ("
				+ "?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getBookmaker(), od.getOddsTime(),
				od.getLine(), od.getOddsHi(), od.getOddsLo()});
	}
	
	private List<DiffHil> list(String sql, Object[] args){
		return (List<DiffHil>)this.jdbcTemplate.query(sql, args, new RowMapperDiffHil());
	}
	
	public DiffHil getLatest(String id) {
		String sql = "SELECT id, bookmaker, oddsTime, "
				+ "line, oddsHi, oddsLo "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffHil result = null;
		try {
			result = (DiffHil)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffHil());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
