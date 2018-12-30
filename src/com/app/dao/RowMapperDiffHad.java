package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHad;

public class RowMapperDiffHad implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHad od = new DiffHad();
		
		od.setId(rs.getString("id"));
		od.setBookmaker(rs.getString("bookmaker"));
		od.setOddsHome(rs.getFloat("oddsHome"));
		od.setOddsAway(rs.getFloat("oddsAway"));
		od.setOddsDraw(rs.getFloat("oddsDraw"));
		od.setOddsTime(rs.getTimestamp("oddsTime"));
		
		return od;
	}

}
