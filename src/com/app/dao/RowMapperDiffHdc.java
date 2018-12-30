package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHdc;

public class RowMapperDiffHdc implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHdc od = new DiffHdc();
		
		od.setId(rs.getString("id"));
		od.setBookmaker(rs.getString("bookmaker"));
		od.setLine(rs.getFloat("line"));
		od.setOddsHome(rs.getFloat("oddsHome"));
		od.setOddsAway(rs.getFloat("oddsAway"));
		od.setOddsTime(rs.getTimestamp("oddsTime"));
		
		return od;
	}

}
