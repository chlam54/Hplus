package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.intf.DiffFhlDao;
import com.app.model.DiffFhl;
import com.app.util.Util;

public class DiffFhlDaoImpl extends AbstractDaoImpl implements DiffFhlDao {
	private final static Logger logger = Util.getLogger(DiffFhlDaoImpl.class);
	
	public DiffFhlDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffFhl od) {
		String sql = "INSERT INTO "+table+" (id, oddsTime, "
				+ "line, oddsHi, oddsLo) VALUES ("
				+ "?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getOddsTime(),
				od.getLine(), od.getOddsHi(), od.getOddsLo()});
	}
	
	private List<DiffFhl> list(String sql, Object[] args){
		return (List<DiffFhl>)this.jdbcTemplate.query(sql, args, new RowMapperDiffFhl());
	}
	
	public DiffFhl getLatest(String id) {
		String sql = "SELECT id, oddsTime, "
				+ "line, oddsHi, oddsLo "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffFhl result = null;
		try {
			result = (DiffFhl)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffFhl());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
