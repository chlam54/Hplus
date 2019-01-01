package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffChl;

public class RowMapperDiffChl implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffChl od = new DiffChl(rs.getString("id")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("line")
				, rs.getFloat("oddsHi")
				, rs.getFloat("oddsLo"));
		
		return od;
	}

}
