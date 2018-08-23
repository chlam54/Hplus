package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.app.model.Match;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MatchDaoImpl extends AbstractDaoImpl implements MatchDao {
	private static final String table = "data.match";
	public MatchDaoImpl() {
		super();
	}
	
	@Override
	public Match get(String id) {
		Match m = null;
		String sql = "select * from "+table+" where id = ?";
		try {
			m = (Match) this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new MatchRowMapper());
		} catch(Exception e) {
			return null;
		}
		return m;
	}
	
	
	private List<Match> list(String sql, Object[] args){
		return (List<Match>)this.jdbcTemplate.query(sql, args, new MatchRowMapper());
	}
	@Override
	public List<Match> updateResultList(){
		return list("select * from "+table+" where "
				+ "result is null and now() >= date_add(matchTime, INTERVAL 7 HOUR);", new Object[] {});
	}
	@Override
	public void updateResult(Match m) {
		String sql = "UPDATE "+table+" SET "
				+ "result = ?, "
				+ "resultHomeGoal = ?, "
				+ "resultAwayGoal = ?, "
				+ "resultTotalGoal = ?, "
				+ "resultHad = ?, "
				+ "resultHdcHomeRoi = ?, "
				+ "resultHdcAwayRoi = ?, "
				+ "resultCorner = ? "
				+ "WHERE id = ?";
		this.jdbcTemplate.update(sql, m.getResult(), m.getResultHomeGoal(), m.getResultAwayGoal(), m.getResultTotalGoal(), 
				m.getResultHad(), m.getResultHdcHomeRoi(), m.getResultHdcAwayRoi(), m.getResultCorner(), m.getId());
	}
	
	@Override
	public void save(Match m) {
		String sql = "INSERT INTO "+table+" (id, matchNum, matchDate, matchTime, matchType, matchTypeEn, "
				+ "homeName, awayName, homeNameEn, awayNameEn, homeLRank, awayLRank, "
				+ "oddsTime, oddsHadHome, oddsHadDraw, oddsHadAway, "
				+ "oddsHandicapLine, oddsHandicapHome, oddsHandicapAway, oddsHiLoLine, oddsHiLoHigh, oddsHiLoLow, "
				+ "oddsCornerHiLoLine, oddsCornerHiLoHigh, oddsCornerHiLoLow, "
				+ "rf1HomeType, rf1HomeDate, rf1HomeRole, rf1HomeAgst, rf1HomeResult, rf1HomeGoal, rf1HomeOppGoal, rf1HomeWdl, rf1HomeHdcLine, rf1HomeHdcRoi, rf1HomeHhadLine, rf1HomeCorner, "
				+ "rf2HomeType, rf2HomeDate, rf2HomeRole, rf2HomeAgst, rf2HomeResult, rf2HomeGoal, rf2HomeOppGoal, rf2HomeWdl, rf2HomeHdcLine, rf2HomeHdcRoi, rf2HomeHhadLine, rf2HomeCorner, "
				+ "rf3HomeType, rf3HomeDate, rf3HomeRole, rf3HomeAgst, rf3HomeResult, rf3HomeGoal, rf3HomeOppGoal, rf3HomeWdl, rf3HomeHdcLine, rf3HomeHdcRoi, rf3HomeHhadLine, rf3HomeCorner, "
				+ "rf4HomeType, rf4HomeDate, rf4HomeRole, rf4HomeAgst, rf4HomeResult, rf4HomeGoal, rf4HomeOppGoal, rf4HomeWdl, rf4HomeHdcLine, rf4HomeHdcRoi, rf4HomeHhadLine, rf4HomeCorner, "
				+ "rf5HomeType, rf5HomeDate, rf5HomeRole, rf5HomeAgst, rf5HomeResult, rf5HomeGoal, rf5HomeOppGoal, rf5HomeWdl, rf5HomeHdcLine, rf5HomeHdcRoi, rf5HomeHhadLine, rf5HomeCorner, "
				+ "rf6HomeType, rf6HomeDate, rf6HomeRole, rf6HomeAgst, rf6HomeResult, rf6HomeGoal, rf6HomeOppGoal, rf6HomeWdl, rf6HomeHdcLine, rf6HomeHdcRoi, rf6HomeHhadLine, rf6HomeCorner, "
				+ "rf7HomeType, rf7HomeDate, rf7HomeRole, rf7HomeAgst, rf7HomeResult, rf7HomeGoal, rf7HomeOppGoal, rf7HomeWdl, rf7HomeHdcLine, rf7HomeHdcRoi, rf7HomeHhadLine, rf7HomeCorner, "
				+ "rf8HomeType, rf8HomeDate, rf8HomeRole, rf8HomeAgst, rf8HomeResult, rf8HomeGoal, rf8HomeOppGoal, rf8HomeWdl, rf8HomeHdcLine, rf8HomeHdcRoi, rf8HomeHhadLine, rf8HomeCorner, "
				+ "rf1AwayType, rf1AwayDate, rf1AwayRole, rf1AwayAgst, rf1AwayResult, rf1AwayGoal, rf1AwayOppGoal, rf1AwayWdl, rf1AwayHdcLine, rf1AwayHdcRoi, rf1AwayHhadLine, rf1AwayCorner, "
				+ "rf2AwayType, rf2AwayDate, rf2AwayRole, rf2AwayAgst, rf2AwayResult, rf2AwayGoal, rf2AwayOppGoal, rf2AwayWdl, rf2AwayHdcLine, rf2AwayHdcRoi, rf2AwayHhadLine, rf2AwayCorner, "
				+ "rf3AwayType, rf3AwayDate, rf3AwayRole, rf3AwayAgst, rf3AwayResult, rf3AwayGoal, rf3AwayOppGoal, rf3AwayWdl, rf3AwayHdcLine, rf3AwayHdcRoi, rf3AwayHhadLine, rf3AwayCorner, "
				+ "rf4AwayType, rf4AwayDate, rf4AwayRole, rf4AwayAgst, rf4AwayResult, rf4AwayGoal, rf4AwayOppGoal, rf4AwayWdl, rf4AwayHdcLine, rf4AwayHdcRoi, rf4AwayHhadLine, rf4AwayCorner, "
				+ "rf5AwayType, rf5AwayDate, rf5AwayRole, rf5AwayAgst, rf5AwayResult, rf5AwayGoal, rf5AwayOppGoal, rf5AwayWdl, rf5AwayHdcLine, rf5AwayHdcRoi, rf5AwayHhadLine, rf5AwayCorner, "
				+ "rf6AwayType, rf6AwayDate, rf6AwayRole, rf6AwayAgst, rf6AwayResult, rf6AwayGoal, rf6AwayOppGoal, rf6AwayWdl, rf6AwayHdcLine, rf6AwayHdcRoi, rf6AwayHhadLine, rf6AwayCorner, "
				+ "rf7AwayType, rf7AwayDate, rf7AwayRole, rf7AwayAgst, rf7AwayResult, rf7AwayGoal, rf7AwayOppGoal, rf7AwayWdl, rf7AwayHdcLine, rf7AwayHdcRoi, rf7AwayHhadLine, rf7AwayCorner, "
				+ "rf8AwayType, rf8AwayDate, rf8AwayRole, rf8AwayAgst, rf8AwayResult, rf8AwayGoal, rf8AwayOppGoal, rf8AwayWdl, rf8AwayHdcLine, rf8AwayHdcRoi, rf8AwayHhadLine, rf8AwayCorner, "
				+ "result, resultHomeGoal, resultAwayGoal, resultTotalGoal, resultHad, resultHdcHomeRoi, resultHdcAwayRoi, resultCorner) VALUES ("
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if(get(m.getId())==null) {
			try {
				this.jdbcTemplate.update(sql, new Object[] {
				m.getId(), m.getMatchNum(), m.getMatchDate(), m.getMatchTime(), m.getMatchType(), m.getMatchTypeEn(),
				m.getHomeName(), m.getAwayName(), m.getHomeNameEn(), m.getAwayNameEn(), m.getHomeLRank(), m.getAwayLRank(),
				new Date(), m.getOddsHadHome(), m.getOddsHadDraw(), m.getOddsHadAway(),
				m.getOddsHandicapLine(), m.getOddsHandicapHome(), m.getOddsHandicapAway(),
				m.getOddsHiLoLine(), m.getOddsHiLoHigh(), m.getOddsHiLoLow(),
				m.getOddsCornerHiLoLine(), m.getOddsCornerHiLoHigh(), m.getOddsCornerHiLoLow(),
				m.getRfHome().get(0).getType(), m.getRfHome().get(0).getDate(), m.getRfHome().get(0).getRole(), m.getRfHome().get(0).getAgst(), m.getRfHome().get(0).getResult(), m.getRfHome().get(0).getGoal(), m.getRfHome().get(0).getOppGoal(), m.getRfHome().get(0).getWdl(), m.getRfHome().get(0).getHdcLine(), m.getRfHome().get(0).getHdcRoi(), m.getRfHome().get(0).getHhadLine(), m.getRfHome().get(0).getCorner(), 
				m.getRfHome().get(1).getType(), m.getRfHome().get(1).getDate(), m.getRfHome().get(1).getRole(), m.getRfHome().get(1).getAgst(), m.getRfHome().get(1).getResult(), m.getRfHome().get(1).getGoal(), m.getRfHome().get(1).getOppGoal(), m.getRfHome().get(1).getWdl(), m.getRfHome().get(1).getHdcLine(), m.getRfHome().get(1).getHdcRoi(), m.getRfHome().get(1).getHhadLine(), m.getRfHome().get(1).getCorner(),
				m.getRfHome().get(2).getType(), m.getRfHome().get(2).getDate(), m.getRfHome().get(2).getRole(), m.getRfHome().get(2).getAgst(), m.getRfHome().get(2).getResult(), m.getRfHome().get(2).getGoal(), m.getRfHome().get(2).getOppGoal(), m.getRfHome().get(2).getWdl(), m.getRfHome().get(2).getHdcLine(), m.getRfHome().get(2).getHdcRoi(), m.getRfHome().get(2).getHhadLine(), m.getRfHome().get(2).getCorner(),
				m.getRfHome().get(3).getType(), m.getRfHome().get(3).getDate(), m.getRfHome().get(3).getRole(), m.getRfHome().get(3).getAgst(), m.getRfHome().get(3).getResult(), m.getRfHome().get(3).getGoal(), m.getRfHome().get(3).getOppGoal(), m.getRfHome().get(3).getWdl(), m.getRfHome().get(3).getHdcLine(), m.getRfHome().get(3).getHdcRoi(), m.getRfHome().get(3).getHhadLine(), m.getRfHome().get(3).getCorner(),
				m.getRfHome().get(4).getType(), m.getRfHome().get(4).getDate(), m.getRfHome().get(4).getRole(), m.getRfHome().get(4).getAgst(), m.getRfHome().get(4).getResult(), m.getRfHome().get(4).getGoal(), m.getRfHome().get(4).getOppGoal(), m.getRfHome().get(4).getWdl(), m.getRfHome().get(4).getHdcLine(), m.getRfHome().get(4).getHdcRoi(), m.getRfHome().get(4).getHhadLine(), m.getRfHome().get(4).getCorner(),
				m.getRfHome().get(5).getType(), m.getRfHome().get(5).getDate(), m.getRfHome().get(5).getRole(), m.getRfHome().get(5).getAgst(), m.getRfHome().get(5).getResult(), m.getRfHome().get(5).getGoal(), m.getRfHome().get(5).getOppGoal(), m.getRfHome().get(5).getWdl(), m.getRfHome().get(5).getHdcLine(), m.getRfHome().get(5).getHdcRoi(), m.getRfHome().get(5).getHhadLine(), m.getRfHome().get(5).getCorner(),
				m.getRfHome().get(6).getType(), m.getRfHome().get(6).getDate(), m.getRfHome().get(6).getRole(), m.getRfHome().get(6).getAgst(), m.getRfHome().get(6).getResult(), m.getRfHome().get(6).getGoal(), m.getRfHome().get(6).getOppGoal(), m.getRfHome().get(6).getWdl(), m.getRfHome().get(6).getHdcLine(), m.getRfHome().get(6).getHdcRoi(), m.getRfHome().get(6).getHhadLine(), m.getRfHome().get(6).getCorner(),
				m.getRfHome().get(7).getType(), m.getRfHome().get(7).getDate(), m.getRfHome().get(7).getRole(), m.getRfHome().get(7).getAgst(), m.getRfHome().get(7).getResult(), m.getRfHome().get(7).getGoal(), m.getRfHome().get(7).getOppGoal(), m.getRfHome().get(7).getWdl(), m.getRfHome().get(7).getHdcLine(), m.getRfHome().get(7).getHdcRoi(), m.getRfHome().get(7).getHhadLine(), m.getRfHome().get(7).getCorner(),
				m.getRfAway().get(0).getType(), m.getRfAway().get(0).getDate(), m.getRfAway().get(0).getRole(), m.getRfAway().get(0).getAgst(), m.getRfAway().get(0).getResult(), m.getRfAway().get(0).getGoal(), m.getRfAway().get(0).getOppGoal(), m.getRfAway().get(0).getWdl(), m.getRfAway().get(0).getHdcLine(), m.getRfAway().get(0).getHdcRoi(), m.getRfAway().get(0).getHhadLine(), m.getRfAway().get(0).getCorner(), 
				m.getRfAway().get(1).getType(), m.getRfAway().get(1).getDate(), m.getRfAway().get(1).getRole(), m.getRfAway().get(1).getAgst(), m.getRfAway().get(1).getResult(), m.getRfAway().get(1).getGoal(), m.getRfAway().get(1).getOppGoal(), m.getRfAway().get(1).getWdl(), m.getRfAway().get(1).getHdcLine(), m.getRfAway().get(1).getHdcRoi(), m.getRfAway().get(1).getHhadLine(), m.getRfAway().get(1).getCorner(),
				m.getRfAway().get(2).getType(), m.getRfAway().get(2).getDate(), m.getRfAway().get(2).getRole(), m.getRfAway().get(2).getAgst(), m.getRfAway().get(2).getResult(), m.getRfAway().get(2).getGoal(), m.getRfAway().get(2).getOppGoal(), m.getRfAway().get(2).getWdl(), m.getRfAway().get(2).getHdcLine(), m.getRfAway().get(2).getHdcRoi(), m.getRfAway().get(2).getHhadLine(), m.getRfAway().get(2).getCorner(),
				m.getRfAway().get(3).getType(), m.getRfAway().get(3).getDate(), m.getRfAway().get(3).getRole(), m.getRfAway().get(3).getAgst(), m.getRfAway().get(3).getResult(), m.getRfAway().get(3).getGoal(), m.getRfAway().get(3).getOppGoal(), m.getRfAway().get(3).getWdl(), m.getRfAway().get(3).getHdcLine(), m.getRfAway().get(3).getHdcRoi(), m.getRfAway().get(3).getHhadLine(), m.getRfAway().get(3).getCorner(),
				m.getRfAway().get(4).getType(), m.getRfAway().get(4).getDate(), m.getRfAway().get(4).getRole(), m.getRfAway().get(4).getAgst(), m.getRfAway().get(4).getResult(), m.getRfAway().get(4).getGoal(), m.getRfAway().get(4).getOppGoal(), m.getRfAway().get(4).getWdl(), m.getRfAway().get(4).getHdcLine(), m.getRfAway().get(4).getHdcRoi(), m.getRfAway().get(4).getHhadLine(), m.getRfAway().get(4).getCorner(),
				m.getRfAway().get(5).getType(), m.getRfAway().get(5).getDate(), m.getRfAway().get(5).getRole(), m.getRfAway().get(5).getAgst(), m.getRfAway().get(5).getResult(), m.getRfAway().get(5).getGoal(), m.getRfAway().get(5).getOppGoal(), m.getRfAway().get(5).getWdl(), m.getRfAway().get(5).getHdcLine(), m.getRfAway().get(5).getHdcRoi(), m.getRfAway().get(5).getHhadLine(), m.getRfAway().get(5).getCorner(),
				m.getRfAway().get(6).getType(), m.getRfAway().get(6).getDate(), m.getRfAway().get(6).getRole(), m.getRfAway().get(6).getAgst(), m.getRfAway().get(6).getResult(), m.getRfAway().get(6).getGoal(), m.getRfAway().get(6).getOppGoal(), m.getRfAway().get(6).getWdl(), m.getRfAway().get(6).getHdcLine(), m.getRfAway().get(6).getHdcRoi(), m.getRfAway().get(6).getHhadLine(), m.getRfAway().get(6).getCorner(),
				m.getRfAway().get(7).getType(), m.getRfAway().get(7).getDate(), m.getRfAway().get(7).getRole(), m.getRfAway().get(7).getAgst(), m.getRfAway().get(7).getResult(), m.getRfAway().get(7).getGoal(), m.getRfAway().get(7).getOppGoal(), m.getRfAway().get(7).getWdl(), m.getRfAway().get(7).getHdcLine(), m.getRfAway().get(7).getHdcRoi(), m.getRfAway().get(7).getHhadLine(), m.getRfAway().get(7).getCorner(),
				m.getResult(), m.getResultHomeGoal(), m.getResultAwayGoal(), m.getResultTotalGoal(), m.getResultHad(), m.getResultHdcHomeRoi(), m.getResultHdcAwayRoi(), m.getResultCorner()
				});
			} catch(Exception e) {
				//skip
			}
		}
	}

	@Override
	public void deleteResult(Match m) {
		this.jdbcTemplate.update("delete from "+table+" where id = ?;", new Object[] {m.getId()});
	}
}
