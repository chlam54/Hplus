package com.app.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.scraper.MatchScraper;
import com.app.util.Util;

@SpringBootApplication
@EnableScheduling
public class Scheduler {
	private final static Logger logger = Util.getLogger(Scheduler.class);

	@Scheduled(fixedDelay = 1000)
	public static void writeSth() {
		logger.info("Sth");
	}

	public static void main(String[] args) {
		// SpringApplication.run(Scheduler.class, args);
		scrapeHKJC();
	}

	public static void scrapeHKJC() {
		MatchScraper.scrape();
	}
}
