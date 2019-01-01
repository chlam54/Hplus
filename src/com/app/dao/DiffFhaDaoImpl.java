package com.app.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.app.intf.DiffFhaDao;
import com.app.model.DiffFha;
import com.app.util.Util;

public class DiffFhaDaoImpl extends AbstractDaoImpl implements DiffFhaDao {
	private final static Logger logger = Util.getLogger(DiffFhaDaoImpl.class);
	
	public DiffFhaDaoImpl() {
		super();
	}
	
	@Override
	public void save(DiffFha od) {
		String sql = "INSERT INTO "+table+" (id, oddsTime, "
				+ "oddsHome, oddsAway, oddsDraw) VALUES ("
				+ "?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, new Object[] {
				od.getId(), od.getOddsTime(),
				od.getOddsHome(), od.getOddsAway(), od.getOddsDraw()});
	}
	
	private List<DiffFha> list(String sql, Object[] args){
		return (List<DiffFha>)this.jdbcTemplate.query(sql, args, new RowMapperDiffFha());
	}
	
	public DiffFha getLatest(String id) {
		String sql = "SELECT id, oddsTime, "
				+ "oddsHome, oddsAway, oddsDraw "
				+ "FROM "+table+" where id = ? "
				+ "AND oddsTime = (SELECT max(oddsTime) FROM "+table+" where id = ? group by id);";
		DiffFha result = null;
		try {
			result = (DiffFha)this.jdbcTemplate.queryForObject(sql, new Object[] {id, id}, 
				new RowMapperDiffFha());
		} catch(Exception e) {
			logger.info("Fail to get Latest::"+id);
		}
		return result;
	}
}
