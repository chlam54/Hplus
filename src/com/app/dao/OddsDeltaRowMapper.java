package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.OddsDelta;

public class OddsDeltaRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		OddsDelta od = new OddsDelta();
		
		od.setId(rs.getString("id"));
		od.setBookmaker(rs.getString("bookmaker"));
		od.setBid(rs.getString("bid"));
		od.setOddsHandicapAway(rs.getFloat("oddsHandicapAway"));
		od.setOddsHandicapHome(rs.getFloat("oddsHandicapHome"));
		od.setOddsHandicapLine(rs.getFloat("oddsHandicapLine"));
		od.setOddsTime(rs.getTimestamp("oddsTime"));
		
		return od;
	}

}
