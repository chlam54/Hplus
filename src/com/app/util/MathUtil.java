package com.app.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.PoissonDistribution;

public class MathUtil {
	public static final int stdScale = 3;
	public static final int calScale = 10;
	
	public static Double stdRound(Double d) {
		Float f = new Float(d);
		return round(f, stdScale).doubleValue();
	}
	public static Float stdRound(Float f) {
		return round(f, stdScale);
	}
	public static Float round(Float f, int scale) {
		BigDecimal bd = new BigDecimal(f);
		return bd.setScale(scale, BigDecimal.ROUND_HALF_DOWN).floatValue();
	}
	public static Float multiply(float a, float b) {
		return round(new BigDecimal(a).multiply(new BigDecimal(b)).floatValue(), calScale);
	}
	public static Float divide(float a, float b) {
		return new BigDecimal(a).divide(new BigDecimal(b), calScale, RoundingMode.HALF_DOWN).floatValue();
	}
	public static Float subtract(float a, float b) {
		return round(new BigDecimal(a).subtract(new BigDecimal(b)).floatValue(), calScale);
	}
	public static Float add(float a, float b) {
		return round(new BigDecimal(a).add(new BigDecimal(b)).floatValue(), calScale);
	}
	public static int compareFloat(float a, float b) {
		return new BigDecimal(a).compareTo(new BigDecimal(b));
	}
	public static Float summation(List<Float> list) {
		BigDecimal temp = new BigDecimal(0);
		for(Float f: list) {
			temp = temp.add(new BigDecimal(f));
		}
		return temp.floatValue();
	}
	public static Float mean(List<Float> list) {
		return divide(summation(list), list.size());
	}
	/**
	 * @param mean
	 * @param x
	 * @param inequalitySign sign ?
	 * @return P(X ? x) <=
	 */
	public static Float poissonProbability(float mean, int x, Sign inequalitySign) {
		PoissonDistribution pd = new PoissonDistribution(mean);
		switch (inequalitySign) {
			case EQ	: return (float)pd.probability(x);
			case LTE	: return (float)pd.cumulativeProbability(x);
			case LT	: return subtract((float)pd.cumulativeProbability(x), (float)pd.probability(x));
			case GT	: return subtract(1f, (float)pd.cumulativeProbability(x));
			case GTE	: return add(subtract(1f, (float)pd.cumulativeProbability(x)), (float)pd.probability(x));
			default	: return null;
		}
	}
}
