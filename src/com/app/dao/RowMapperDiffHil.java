package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHil;

public class RowMapperDiffHil implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHil od = new DiffHil(rs.getString("id")
				, rs.getString("bookmaker")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("line")
				, rs.getFloat("oddsHi")
				, rs.getFloat("oddsLo"));
		
		return od;
	}

}
