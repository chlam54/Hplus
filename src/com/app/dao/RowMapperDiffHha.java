package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHad;

public class RowMapperDiffHha implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHad od = new DiffHad(rs.getString("id")
				, rs.getString("bookmaker")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("oddsHome")
				, rs.getFloat("oddsAway")
				, rs.getFloat("oddsDraw"));
		return od;
	}

}
