package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHiLo;

public class RowMapperDiffHiLo implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHiLo od = new DiffHiLo();
		
		od.setId(rs.getString("id"));
		od.setBookmaker(rs.getString("bookmaker"));
		od.setLine(rs.getFloat("line"));
		od.setOddsHi(rs.getFloat("oddsHi"));
		od.setOddsLo(rs.getFloat("oddsLo"));
		od.setOddsTime(rs.getTimestamp("oddsTime"));
		
		return od;
	}

}
