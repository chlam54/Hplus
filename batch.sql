USE data;
CREATE TABLE `match` (
  `id` varchar(50) NOT NULL,
  `matchNum` varchar(20) NOT NULL,
  `matchDate` varchar(20) NOT NULL,
  `matchTime` datetime NOT NULL,
  `matchType` varchar(20) DEFAULT NULL,
  `matchTypeEn` varchar(50) DEFAULT NULL,
  `homeName` varchar(20) DEFAULT NULL,
  `awayName` varchar(20) DEFAULT NULL,
  `homeNameEn` varchar(50) DEFAULT NULL,
  `awayNameEn` varchar(50) DEFAULT NULL,
  `homeLRank` smallint(6) DEFAULT NULL,
  `awayLRank` smallint(6) DEFAULT NULL,
  `result` varchar(20) DEFAULT NULL,
  `resultHomeGoal` smallint(6) DEFAULT NULL,
  `resultAwayGoal` smallint(6) DEFAULT NULL,
  `resultTotalGoal` smallint(6) DEFAULT NULL,
  `resultHad` smallint(6) DEFAULT NULL,
  `resultHdcHomeRoi` float(5,3) DEFAULT NULL,
  `resultHdcAwayRoi` float(5,3) DEFAULT NULL,
  `resultCorner` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bookmaker` (
	`id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `bid` varchar(50) NOT NULL,
	PRIMARY KEY (`id`, `bookmaker`)
);

CREATE TABLE `diffhad` (
    `id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `oddsHome` float(5,3) DEFAULT NULL,
    `oddsAway` float(5,3) DEFAULT NULL,
	`oddsDraw` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `bookmaker`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `diffhdc` (
    `id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `line` float(5,3) DEFAULT NULL,
    `oddsHome` float(5,3) DEFAULT NULL,
    `oddsAway` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `bookmaker`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `diffhil` (
    `id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `line` float(5,3) DEFAULT NULL,
    `oddsHi` float(5,3) DEFAULT NULL,
    `oddsLo` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `bookmaker`, `line`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Half Time Handicap HAD
CREATE TABLE `diffhha` (
    `id` varchar(50) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `oddsHome` float(5,3) DEFAULT NULL,
    `oddsAway` float(5,3) DEFAULT NULL,
	`oddsDraw` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Half Time HAD
CREATE TABLE `difffha` (
    `id` varchar(50) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `oddsHome` float(5,3) DEFAULT NULL,
    `oddsAway` float(5,3) DEFAULT NULL,
	`oddsDraw` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Half Time HiLo
CREATE TABLE `difffhl` (
    `id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `line` float(5,3) DEFAULT NULL,
    `oddsHi` float(5,3) DEFAULT NULL,
    `oddsLo` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `bookmaker`, `line`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Corner HiLo
CREATE TABLE `diffchl` (
    `id` varchar(50) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `line` float(5,3) DEFAULT NULL,
    `oddsHi` float(5,3) DEFAULT NULL,
    `oddsLo` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `line`, `oddsTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `history` (
	`id` varchar(50) NOT NULL,
	`seq` smallint(6) NOT NULL,
	`team` varchar(5) NOT NULL,
	`game` varchar(20) DEFAULT NULL,
	`date` varchar(20) DEFAULT NULL,
	`histTeam` varchar(5) DEFAULT NULL,
	`agst` varchar(20) DEFAULT NULL,
	`result` varchar(20) DEFAULT NULL,
	`goal` smallint(6) DEFAULT NULL,
	`oppGoal` smallint(6) DEFAULT NULL,
	`wdl` smallint(6) DEFAULT NULL,
	`hdcLine` float(5,3) DEFAULT NULL,
	`hdcRoi` float(5,3) DEFAULT NULL,
	`hhaLine` float(5,3) DEFAULT NULL,
	`corner` smallint(6) DEFAULT NULL,
	PRIMARY KEY (`id`, `seq`, `team`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;