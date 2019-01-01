package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffFha;

public class RowMapperDiffFha implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffFha od = new DiffFha(rs.getString("id")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("oddsHome")
				, rs.getFloat("oddsAway")
				, rs.getFloat("oddsDraw"));
		return od;
	}

}
