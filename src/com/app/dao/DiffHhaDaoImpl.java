package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.intf.DiffHhaDao;
import com.app.model.DiffHha;
import com.app.util.Util;

public class DiffHhaDaoImpl extends AbstractDaoImpl implements DiffHhaDao {
	private final static Logger logger = Util.getLogger(DiffHhaDaoImpl.class);
	
	public DiffHhaDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffHha od) {
		String sql = "INSERT INTO "+table+" (id, oddsTime, "
				+ "line, oddsHome, oddsAway, oddsDraw) VALUES ("
				+ "?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getOddsTime(), od.getLine(),
				od.getOddsHome(), od.getOddsAway(), od.getOddsDraw()});
	}
	
	private List<DiffHha> list(String sql, Object[] args){
		return (List<DiffHha>)this.jdbcTemplate.query(sql, args, new RowMapperDiffHha());
	}
	
	public DiffHha getLatest(String id) {
		String sql = "SELECT id, oddsTime, line, "
				+ "oddsHome, oddsAway, oddsDraw "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffHha result = null;
		try {
			result = (DiffHha)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffHha());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
