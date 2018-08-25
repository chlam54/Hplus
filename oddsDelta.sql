CREATE TABLE `data`.`oddsDelta` (
    `id` varchar(50) NOT NULL,
    `bookmaker` varchar(10) NOT NULL,
    `bid` varchar(50) NOT NULL,
    `oddsTime` datetime NOT NULL,
    `oddsHandicapLine` float(5,3) DEFAULT NULL,
    `oddsHandicapHome` float(5,3) DEFAULT NULL,
    `oddsHandicapAway` float(5,3) DEFAULT NULL,
    PRIMARY KEY (`id`, `bookmaker`, `oddsTime`),
    FOREIGN KEY (`id`) REFERENCES `data`.`match`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;