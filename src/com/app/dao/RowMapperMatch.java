package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.Match;

public class RowMapperMatch implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Match m = new Match(rs.getString("id")
				, rs.getString("matchNum")
				, rs.getString("matchDate")
				, rs.getTimestamp("matchTime")
				, rs.getString("matchType")
				, rs.getString("matchTypeEn")
				, rs.getString("homeName")
				, rs.getString("awayName")
				, rs.getString("homeNameEn")
				, rs.getString("awayNameEn")
				, (Integer) rs.getObject("homeLRank")
				, (Integer) rs.getObject("awayLRank")
				, (Integer) rs.getObject("resultHtHg")
				, (Integer) rs.getObject("resultHtAg")
				, (Integer) rs.getObject("resultFtHg")
				, (Integer) rs.getObject("resultFtAg")
				, (Integer) rs.getObject("resultCorner"));
		return m;
	}

}
