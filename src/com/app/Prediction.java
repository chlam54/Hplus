package com.app;

import java.util.List;

import com.app.dao.MatchDaoImpl;
import com.app.intf.MatchDao;
import com.app.model.Match;
import com.app.model.RecentForm;
import com.app.util.MathUtil;
import com.app.util.Sign;

public class Prediction {
	private static MatchDao mDao = new MatchDaoImpl();
	
	public static void main(String[] args) {
		List<Match> mList = mDao.list("select * from "+mDao.table+" where result is not null and oddsHiLoLine = 2.5;", new Object[] {});
//		List<Match> mList = mDao.list("select * from "+mDao.table+" where id='0072d49b-4e19-45e1-ba92-7c9d253bd539';", new Object[] {});
		float netProfit = 0f;
		int count = 0;
		for(Match m: mList) {
			float y = getLinearRegression(getHistTotalGoal(m));
			float p = betDecide(m.getOddsHiLoHigh(), m.getOddsHiLoLow(), y, m.getResultTotalGoal());
			netProfit = MathUtil.add(netProfit, p);
			count += netProfit!=0?1:0;
		}
		System.out.println("FINAL!!!::"+netProfit+"|"+mList.size()+"|"+count);
	}
	
	public static float betDecide(float oddsHiLoHigh, float oddsHiLoLow, float y, int totalGoal) {
		float Phi = MathUtil.poissonProbability(y, 2, Sign.GT);
		float Plo = MathUtil.poissonProbability(y, 2, Sign.LTE);
		float hkjcPhi = MathUtil.divide(1f, oddsHiLoHigh);
		float hkjcPlo = MathUtil.divide(1f, oddsHiLoLow);
		System.out.println("--");
		float profit = 0f;
		float hpd = MathUtil.subtract(Phi, hkjcPhi);
		float lpd = MathUtil.subtract(Plo, hkjcPlo);
		if(hpd > 0.05 && hpd < 0.15) {
			if(totalGoal>2.5) {
				profit = MathUtil.subtract(oddsHiLoHigh, 1); 
			}else {
				profit = -1;
			}
			System.out.println("Hi"+hpd+","+profit);
		}
		if(lpd > 0.05 && lpd < 0.15) {
			if(totalGoal<2.5) {
				profit = MathUtil.subtract(oddsHiLoLow, 1); 
			}else {
				profit = -1;
			}
			System.out.println("Lo"+lpd+","+profit);
		}
		return profit;
	}
	public static float getLinearRegression(int x) {
		return MathUtil.add(1.09964f, MathUtil.multiply(0.03596f, x));
	}
	public static int getHistTotalGoal(Match m) {
		int totalGoal = 0;
		for(RecentForm rf:m.getRfHome()) {
			totalGoal += rf.getGoal()+rf.getOppGoal();
		}
		for(RecentForm rf:m.getRfAway()) {
			totalGoal += rf.getGoal()+rf.getOppGoal();
		}
		return totalGoal;
	}
}
