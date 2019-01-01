package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffFhl;

public class RowMapperDiffFhl implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffFhl od = new DiffFhl(rs.getString("id")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("line")
				, rs.getFloat("oddsHi")
				, rs.getFloat("oddsLo"));
		
		return od;
	}

}
