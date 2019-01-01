package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.History;

public class RowMapperHistory implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		History history = new History(rs.getString("id")
				, rs.getInt("seq")
				, rs.getString("team")
				, rs.getString("game")
				, rs.getString("date")
				, rs.getString("hisTeam")
				, rs.getString("agst")
				, rs.getString("result")
				, (Integer) rs.getObject("goal")
				, (Integer) rs.getObject("oppGoal")
				, (Integer) rs.getObject("wdl")
				, (Float) rs.getObject("hdcLine")
				, (Float) rs.getObject("hdcRoi")
				, (Float) rs.getObject("hhaLine")
				, (Integer) rs.getObject("corner"));
		
		return history;
	}

}
