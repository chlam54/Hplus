package com.app.util;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.app.scraper.Param;

public class Util {
	private final static Logger logger = getLogger(Util.class);
	public static final Float[] hdcLineArr = new Float[] { -1.75f, -1.25f, -1f, -0.75f, -0.25f, 0f, 0.25f, 0.75f, 1f,
			1.25f };

	public static Date parse(String input, String dateFormat) {
		Date d = null;
		try {
			d = new SimpleDateFormat(dateFormat).parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static String parseDate(Date date, String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(date);
	}

	public static Integer parseCorner(String corner) {
		if ("-".equals(corner))
			return null;
		return Integer.parseInt(Util.removeNonDigit(corner));
	}

	/**
	 * @param stdFormLine
	 *            format| 2.5, 2/2.5, 0/-0.5
	 */
	public static Float parseLine(String stdForm) {
		if ("-".equals(stdForm))
			return null;
		String[] strIntervalArr = stdForm.split("/");
		Float sum = 0f;
		for (int i = 0; i < strIntervalArr.length; i++) {
			sum += Float.parseFloat(strIntervalArr[i]);
		}
		return sum / strIntervalArr.length;
	}

	public static Integer parseResult(String result, boolean isHome) {
		String stdForm = result.split(" ")[0].replaceAll("\\[.*?\\] ?", "");
		String ft = stdForm.split("\\(")[0];
		try {
			return isHome ? Integer.parseInt(ft.split(":")[0]) : Integer.parseInt(ft.split(":")[1]);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer parseStatResult(String statResult, boolean isOpp) {
		String stdForm = statResult.split(" ")[0].replaceAll("\\[.*?\\] ?", "");
		String ft = stdForm.split("\\(")[0];
		try {
			return isOpp ? Integer.parseInt(ft.split(":")[1]) : Integer.parseInt(ft.split(":")[0]);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer parseStatHad(String statResult) {
		Integer goal = parseStatResult(statResult, false);
		Integer oppGoal = parseStatResult(statResult, true);
		if (goal == null || oppGoal == null)
			return null;
		else if (goal < oppGoal)
			return -1;
		else if (goal > oppGoal)
			return 1;
		else
			return 0;
	}
	
	public static Float calResultHdcRoi(String result, Float homeHdcLine, Float hdcOdds, boolean isHome) {
		Float output = null;
		Float tempRoi = calHdcRoi(result, homeHdcLine);
		if(tempRoi == null) {
			return null;
		}
		if (!isHome) {
			tempRoi = -tempRoi;
		}
		if (tempRoi == 0.5f)
			output = MathUtil.stdRound(0.5f * (hdcOdds - 1));
		else if (tempRoi == 1f)
			output = (hdcOdds - 1);
		else
			output = tempRoi;
		return MathUtil.stdRound(output);
	}

	public static Float calHdcRoi(String result, Float homeHdcLine) {
		Float roi = null;
		if (result == null || homeHdcLine == null)
			return roi;
		int homeGoal = parseResult(result, true);
		int awayGoal = parseResult(result, false);
		float hdcIndex = homeGoal - awayGoal + homeHdcLine;
		if (hdcIndex == 0.25)
			return 0.5f;
		else if (hdcIndex == -0.25)
			return -0.5f;
		else if (hdcIndex == 0)
			return 0f;
		else if (hdcIndex > 0.25)
			return 1f;
		else if (hdcIndex < -0.25)
			return -1f;
		else {
			logger.error("Invalid Hdc Roi");
			return null;
		}
	}

	public static void writeFile(String fileName, String content) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String removeNonDigit(String input) {
		return input.replaceAll("\\D+", "");
	}

	public static Integer parseRecentFormRank(String str) {
		try {
			return Integer.parseInt(removeNonDigit(str));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Calculates the similarity (a number within 0 and 1) between two strings.
	 */
	public static double similarity(String s1, String s2) {
		String longer = s1, shorter = s2;
		if (s1.length() < s2.length()) { // longer should always have greater length
			longer = s2;
			shorter = s1;
		}
		int longerLength = longer.length();
		if (longerLength == 0) {
			return 1.0;
			/* both strings are zero length */ }
		return (longerLength - editDistance(longer, shorter)) / (double) longerLength;
	}

	private static int editDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}
	public static String getProperty(String properties, String key) {
		try {
			InputStream input = new FileInputStream(properties);
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			return prop.getProperty(key);
		} catch (Exception e) {
			logger.error("Fail to retrieve the properties: "+properties+" :: "+key);
			return null;
		}
	}
	public static Logger getLogger(Class clazz) {
		Properties p = new Properties();
		String log4JPropertyFile = "log4j.properties";
		try {
		    p.load(new FileInputStream(log4JPropertyFile));
		    PropertyConfigurator.configure(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Logger.getLogger(clazz);
	}
	public static Timestamp parseDate(Date d) {
		return new Timestamp(d.getTime());
	}
	public static void sleep() {
		try {
			Thread.sleep(Param.sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void sleep(int milisec) {
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static Date getHongKongDate() {
		Date date = new Date();
		SimpleDateFormat sdfHK = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		sdfHK.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));
		String dateStrHK = sdfHK.format(date);
		try {
			return sdfHK.parse(dateStrHK);
		} catch (ParseException e) {
			return date;
		}
	}
	public static void main(String[] args) {
		System.out.println(getHongKongDate());
	}
}
