package com.app.service;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.scraper.MatchScraper;
import com.app.util.Util;

@SpringBootApplication
@EnableScheduling
public class Scheduler {
	private final static Logger logger = Util.getLogger(Scheduler.class);

	//600000
	@Scheduled(fixedDelay = 600)
	public static void writeSth() {
		System.out.println("hi");
//		scrapeHKJC();
	}

	public static void main(String[] args) {
		SpringApplication.run(Scheduler.class, args);
	}

	public static void scrapeHKJC() {
		MatchScraper.scrape();
	}
}
