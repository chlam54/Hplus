package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.intf.DiffChlDao;
import com.app.model.DiffChl;
import com.app.util.Util;

public class DiffChlDaoImpl extends AbstractDaoImpl implements DiffChlDao {
	private final static Logger logger = Util.getLogger(DiffChlDaoImpl.class);
	
	public DiffChlDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffChl od) {
		String sql = "INSERT INTO "+table+" (id, oddsTime, "
				+ "line, oddsHi, oddsLo) VALUES ("
				+ "?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getOddsTime(),
				od.getLine(), od.getOddsHi(), od.getOddsLo()});
	}
	
	private List<DiffChl> list(String sql, Object[] args){
		return (List<DiffChl>)this.jdbcTemplate.query(sql, args, new RowMapperDiffChl());
	}
	
	public DiffChl getLatest(String id) {
		String sql = "SELECT id, oddsTime, "
				+ "line, oddsHi, oddsLo "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffChl result = null;
		try {
			result = (DiffChl)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffChl());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
