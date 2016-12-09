CREATE TABLE `customer` (
  `customer_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `enabled` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `bank_account` (
  `bank_account_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `balance` decimal(10,2) NOT NULL,
  `locked` tinyint(1) unsigned NOT NULL,
  `customer_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`bank_account_id`),
  KEY `fk_bank_account_customer_id` (`customer_id`),
  CONSTRAINT `fk_bank_account_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;