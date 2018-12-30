package com.app;

import org.apache.log4j.Logger;

import com.app.dao.MatchDaoImpl;
import com.app.scraper.ImageScraper;
import com.app.scraper.MatchScraper;
import com.app.util.Util;

public class Scheduler {
	private final static Logger logger = Util.getLogger(Scheduler.class);
	
	public static void run() {
		MatchScraper.scrape();
	}

	public static void main(String[] args) {
		while(true) {
			ImageScraper.execute();
			run();
			Util.sleep(600000);
		}
	}
}
