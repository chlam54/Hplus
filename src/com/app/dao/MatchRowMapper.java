package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;

import com.app.model.Match;
import com.app.model.RecentForm;

public class MatchRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Match m = new Match();
		m.setId(rs.getString("id"));
		m.setMatchNum(rs.getString("matchNum"));
		m.setMatchDate(rs.getString("matchDate"));
		m.setMatchTime(rs.getDate("matchTime"));
		m.setMatchType(rs.getString("matchType"));
		m.setMatchTypeEn(rs.getString("matchTypeEn"));
		m.setHomeName(rs.getString("homeName"));
		m.setAwayName(rs.getString("awayName"));
		m.setHomeNameEn(rs.getString("homeNameEn"));
		m.setAwayNameEn(rs.getString("awayNameEn"));
		m.setHomeLRank((Integer) rs.getObject("homeLRank"));
		m.setAwayLRank((Integer) rs.getObject("awayLRank"));
		
		m.setOddsTime(rs.getDate("oddsTime"));
		m.setOddsHadHome((Float) rs.getObject("oddsHadHome"));
		m.setOddsHadDraw((Float) rs.getObject("oddsHadDraw"));
		m.setOddsHadAway((Float) rs.getObject("oddsHadAway"));
		m.setOddsHandicapLine((Float) rs.getObject("oddsHandicapLine"));
		m.setOddsHandicapHome((Float) rs.getObject("oddsHandicapHome"));
		m.setOddsHandicapAway((Float) rs.getObject("oddsHandicapAway"));
		m.setOddsHiLoLine((Float) rs.getObject("oddsHiLoLine"));
		m.setOddsHiLoHigh((Float) rs.getObject("oddsHiLoHigh"));
		m.setOddsHiLoLow((Float) rs.getObject("oddsHiLoLow"));
		m.setOddsCornerHiLoLine((Float) rs.getObject("oddsCornerHiLoLine"));
		m.setOddsCornerHiLoHigh((Float) rs.getObject("oddsCornerHiLoHigh"));
		m.setOddsCornerHiLoLow((Float) rs.getObject("oddsCornerHiLoLow"));
		
		ArrayList<RecentForm> rfHome = new ArrayList<RecentForm>();
		ArrayList<RecentForm> rfAway = new ArrayList<RecentForm>();
		rfHome.add(new RecentForm(rs.getString("rf1HomeType"), rs.getString("rf1HomeDate"), rs.getString("rf1HomeRole"), rs.getString("rf1HomeAgst"), rs.getString("rf1HomeResult"),
				(Integer) rs.getObject("rf1HomeGoal"), (Integer) rs.getObject("rf1HomeOppGoal"), (Integer) rs.getObject("rf1HomeWdl"),
				(Float) rs.getObject("rf1HomeHdcLine"), (Float) rs.getObject("rf1HomeHdcRoi"), (Float) rs.getObject("rf1HomeHhadLine"), (Integer) rs.getObject("rf1HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf2HomeType"), rs.getString("rf2HomeDate"), rs.getString("rf2HomeRole"), rs.getString("rf2HomeAgst"), rs.getString("rf2HomeResult"),
				(Integer) rs.getObject("rf2HomeGoal"), (Integer) rs.getObject("rf2HomeOppGoal"), (Integer) rs.getObject("rf2HomeWdl"),
				(Float) rs.getObject("rf2HomeHdcLine"), (Float) rs.getObject("rf2HomeHdcRoi"), (Float) rs.getObject("rf2HomeHhadLine"), (Integer) rs.getObject("rf2HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf3HomeType"), rs.getString("rf3HomeDate"), rs.getString("rf3HomeRole"), rs.getString("rf3HomeAgst"), rs.getString("rf3HomeResult"),
				(Integer) rs.getObject("rf3HomeGoal"), (Integer) rs.getObject("rf3HomeOppGoal"), (Integer) rs.getObject("rf3HomeWdl"),
				(Float) rs.getObject("rf3HomeHdcLine"), (Float) rs.getObject("rf3HomeHdcRoi"), (Float) rs.getObject("rf3HomeHhadLine"), (Integer) rs.getObject("rf3HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf4HomeType"), rs.getString("rf4HomeDate"), rs.getString("rf4HomeRole"), rs.getString("rf4HomeAgst"), rs.getString("rf4HomeResult"),
				(Integer) rs.getObject("rf4HomeGoal"), (Integer) rs.getObject("rf4HomeOppGoal"), (Integer) rs.getObject("rf4HomeWdl"),
				(Float) rs.getObject("rf4HomeHdcLine"), (Float) rs.getObject("rf4HomeHdcRoi"), (Float) rs.getObject("rf4HomeHhadLine"), (Integer) rs.getObject("rf4HomeCorner")));
		
		rfHome.add(new RecentForm(rs.getString("rf5HomeType"), rs.getString("rf5HomeDate"), rs.getString("rf5HomeRole"), rs.getString("rf5HomeAgst"), rs.getString("rf5HomeResult"),
				(Integer) rs.getObject("rf5HomeGoal"), (Integer) rs.getObject("rf5HomeOppGoal"), (Integer) rs.getObject("rf5HomeWdl"),
				(Float) rs.getObject("rf5HomeHdcLine"), (Float) rs.getObject("rf5HomeHdcRoi"), (Float) rs.getObject("rf5HomeHhadLine"), (Integer) rs.getObject("rf5HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf6HomeType"), rs.getString("rf6HomeDate"), rs.getString("rf6HomeRole"), rs.getString("rf6HomeAgst"), rs.getString("rf6HomeResult"),
				(Integer) rs.getObject("rf6HomeGoal"), (Integer) rs.getObject("rf6HomeOppGoal"), (Integer) rs.getObject("rf6HomeWdl"),
				(Float) rs.getObject("rf6HomeHdcLine"), (Float) rs.getObject("rf6HomeHdcRoi"), (Float) rs.getObject("rf6HomeHhadLine"), (Integer) rs.getObject("rf6HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf7HomeType"), rs.getString("rf7HomeDate"), rs.getString("rf7HomeRole"), rs.getString("rf7HomeAgst"), rs.getString("rf7HomeResult"),
				(Integer) rs.getObject("rf7HomeGoal"), (Integer) rs.getObject("rf7HomeOppGoal"), (Integer) rs.getObject("rf7HomeWdl"),
				(Float) rs.getObject("rf7HomeHdcLine"), (Float) rs.getObject("rf7HomeHdcRoi"), (Float) rs.getObject("rf7HomeHhadLine"), (Integer) rs.getObject("rf7HomeCorner")));
		rfHome.add(new RecentForm(rs.getString("rf8HomeType"), rs.getString("rf8HomeDate"), rs.getString("rf8HomeRole"), rs.getString("rf8HomeAgst"), rs.getString("rf8HomeResult"),
				(Integer) rs.getObject("rf8HomeGoal"), (Integer) rs.getObject("rf8HomeOppGoal"), (Integer) rs.getObject("rf8HomeWdl"),
				(Float) rs.getObject("rf8HomeHdcLine"), (Float) rs.getObject("rf8HomeHdcRoi"), (Float) rs.getObject("rf8HomeHhadLine"), (Integer) rs.getObject("rf8HomeCorner")));
		
		
		rfAway.add(new RecentForm(rs.getString("rf1AwayType"), rs.getString("rf1AwayDate"), rs.getString("rf1AwayRole"), rs.getString("rf1AwayAgst"), rs.getString("rf1AwayResult"),
				(Integer) rs.getObject("rf1AwayGoal"), (Integer) rs.getObject("rf1AwayOppGoal"), (Integer) rs.getObject("rf1AwayWdl"),
				(Float) rs.getObject("rf1AwayHdcLine"), (Float) rs.getObject("rf1AwayHdcRoi"), (Float) rs.getObject("rf1AwayHhadLine"), (Integer) rs.getObject("rf1AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf2AwayType"), rs.getString("rf2AwayDate"), rs.getString("rf2AwayRole"), rs.getString("rf2AwayAgst"), rs.getString("rf2AwayResult"),
				(Integer) rs.getObject("rf2AwayGoal"), (Integer) rs.getObject("rf2AwayOppGoal"), (Integer) rs.getObject("rf2AwayWdl"),
				(Float) rs.getObject("rf2AwayHdcLine"), (Float) rs.getObject("rf2AwayHdcRoi"), (Float) rs.getObject("rf2AwayHhadLine"), (Integer) rs.getObject("rf2AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf3AwayType"), rs.getString("rf3AwayDate"), rs.getString("rf3AwayRole"), rs.getString("rf3AwayAgst"), rs.getString("rf3AwayResult"),
				(Integer) rs.getObject("rf3AwayGoal"), (Integer) rs.getObject("rf3AwayOppGoal"), (Integer) rs.getObject("rf3AwayWdl"),
				(Float) rs.getObject("rf3AwayHdcLine"), (Float) rs.getObject("rf3AwayHdcRoi"), (Float) rs.getObject("rf3AwayHhadLine"), (Integer) rs.getObject("rf3AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf4AwayType"), rs.getString("rf4AwayDate"), rs.getString("rf4AwayRole"), rs.getString("rf4AwayAgst"), rs.getString("rf4AwayResult"),
				(Integer) rs.getObject("rf4AwayGoal"), (Integer) rs.getObject("rf4AwayOppGoal"), (Integer) rs.getObject("rf4AwayWdl"),
				(Float) rs.getObject("rf4AwayHdcLine"), (Float) rs.getObject("rf4AwayHdcRoi"), (Float) rs.getObject("rf4AwayHhadLine"), (Integer) rs.getObject("rf4AwayCorner")));
		
		rfAway.add(new RecentForm(rs.getString("rf5AwayType"), rs.getString("rf5AwayDate"), rs.getString("rf5AwayRole"), rs.getString("rf5AwayAgst"), rs.getString("rf5AwayResult"),
				(Integer) rs.getObject("rf5AwayGoal"), (Integer) rs.getObject("rf5AwayOppGoal"), (Integer) rs.getObject("rf5AwayWdl"),
				(Float) rs.getObject("rf5AwayHdcLine"), (Float) rs.getObject("rf5AwayHdcRoi"), (Float) rs.getObject("rf5AwayHhadLine"), (Integer) rs.getObject("rf5AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf6AwayType"), rs.getString("rf6AwayDate"), rs.getString("rf6AwayRole"), rs.getString("rf6AwayAgst"), rs.getString("rf6AwayResult"),
				(Integer) rs.getObject("rf6AwayGoal"), (Integer) rs.getObject("rf6AwayOppGoal"), (Integer) rs.getObject("rf6AwayWdl"),
				(Float) rs.getObject("rf6AwayHdcLine"), (Float) rs.getObject("rf6AwayHdcRoi"), (Float) rs.getObject("rf6AwayHhadLine"), (Integer) rs.getObject("rf6AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf7AwayType"), rs.getString("rf7AwayDate"), rs.getString("rf7AwayRole"), rs.getString("rf7AwayAgst"), rs.getString("rf7AwayResult"),
				(Integer) rs.getObject("rf7AwayGoal"), (Integer) rs.getObject("rf7AwayOppGoal"), (Integer) rs.getObject("rf7AwayWdl"),
				(Float) rs.getObject("rf7AwayHdcLine"), (Float) rs.getObject("rf7AwayHdcRoi"), (Float) rs.getObject("rf7AwayHhadLine"), (Integer) rs.getObject("rf7AwayCorner")));
		rfAway.add(new RecentForm(rs.getString("rf8AwayType"), rs.getString("rf8AwayDate"), rs.getString("rf8AwayRole"), rs.getString("rf8AwayAgst"), rs.getString("rf8AwayResult"),
				(Integer) rs.getObject("rf8AwayGoal"), (Integer) rs.getObject("rf8AwayOppGoal"), (Integer) rs.getObject("rf8AwayWdl"),
				(Float) rs.getObject("rf8AwayHdcLine"), (Float) rs.getObject("rf8AwayHdcRoi"), (Float) rs.getObject("rf8AwayHhadLine"), (Integer) rs.getObject("rf8AwayCorner")));
		
		m.setRfHome(rfHome);
		m.setRfAway(rfAway);
		
		m.setResult(rs.getString("result"));
		m.setResultHomeGoal((Integer) rs.getObject("resultHomeGoal"));
		m.setResultAwayGoal((Integer) rs.getObject("resultAwayGoal"));
		m.setResultTotalGoal((Integer) rs.getObject("resultTotalGoal"));
		m.setResultHad((Integer) rs.getObject("resultHad"));
		m.setResultHdcHomeRoi((Float) rs.getObject("resultHdcHomeRoi"));
		m.setResultHdcAwayRoi((Float) rs.getObject("resultHdcAwayRoi"));
		m.setResultCorner((Integer) rs.getObject("resultCorner"));
		return m;
	}

}
