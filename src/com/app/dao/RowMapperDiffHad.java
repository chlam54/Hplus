package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHha;

public class RowMapperDiffHad implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHha od = new DiffHha(rs.getString("id")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("line")
				, rs.getFloat("oddsHome")
				, rs.getFloat("oddsAway")
				, rs.getFloat("oddsDraw"));
		return od;
	}

}
