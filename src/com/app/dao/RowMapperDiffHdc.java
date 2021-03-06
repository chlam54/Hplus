package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.DiffHdc;

public class RowMapperDiffHdc implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiffHdc od = new DiffHdc(rs.getString("id")
				, rs.getString("bookmaker")
				, rs.getTimestamp("oddsTime")
				, rs.getFloat("line")
				, rs.getFloat("oddsHome")
				, rs.getFloat("oddsAway"));
		return od;
	}

}
