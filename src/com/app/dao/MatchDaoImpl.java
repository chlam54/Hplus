package com.app.dao;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.app.intf.MatchDao;
import com.app.model.Match;
import com.app.util.Util;

public class MatchDaoImpl extends AbstractDaoImpl implements MatchDao {
	public MatchDaoImpl() {
		super();
	}
	
	@Override
	public Match get(String id) {
		Match m = null;
		String sql = "select * from "+table+" where id = ?";
		try {
			m = (Match) this.jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapperMatch());
		} catch(Exception e) {
			return null;
		}
		return m;
	}
	
	@Override
	public List<Match> list(String sql, Object[] args){
		return (List<Match>)this.jdbcTemplate.query(sql, args, new RowMapperMatch());
	}
	@Override
	public List<Match> updateResultList(){
		return list("select * from "+table+" where "
				+ "result is null and now() >= date_add(matchTime, INTERVAL 7 HOUR);", new Object[] {});
	}
	@Override
	public void updateResult(Match m) {
		String sql = "UPDATE "+table+" SET "
				+ "resultHtHg = ?, "
				+ "resultHtAg = ?, "
				+ "resultFtHg = ?, "
				+ "resultFtAg = ?, "
				+ "resultCorner = ? "
				+ "WHERE id = ?";
		this.jdbcTemplate.update(sql, m.getResultHtHg()
				, m.getResultHtAg()
				, m.getResultFtHg()
				, m.getResultFtAg()
				, m.getResultCorner(), m.getId());
	}
	
	@Override
	public void save(Match m) {
		String sql = "INSERT INTO "+table+" (id, matchNum, matchDate, matchTime, matchType, matchTypeEn, "
				+ "homeName, awayName, homeNameEn, awayNameEn, homeLRank, awayLRank, "
				+ "resultHtHg, resultHtAg,resultFtHg, resultFtAg, resultCorner) VALUES ("
				+ "?,?,?,?,?,?"
				+ ",?,?,?,?,?,?"
				+ ",?,?,?,?,?)";
		if(get(m.getId())==null) {
			try {
				this.jdbcTemplate.update(sql, new Object[] {
				m.getId(), m.getMatchNum(), m.getMatchDate(), m.getMatchTime(), m.getMatchType(), m.getMatchTypeEn(),
				m.getHomeName(), m.getAwayName(), m.getHomeNameEn(), m.getAwayNameEn(), m.getHomeLRank(), m.getAwayLRank(),
				m.getResultHtHg(), m.getResultHtAg(), m.getResultFtHg()
				, m.getResultFtAg(), m.getResultCorner()});
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
