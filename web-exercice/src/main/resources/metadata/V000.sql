CREATE TABLE IF NOT EXISTS `DB_VERSION` (
  `VERSION` varchar(50) NOT NULL,
  `FILE_NAME` varchar(100) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NULL DEFAULT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`VERSION`)
);
