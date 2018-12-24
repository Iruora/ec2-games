CREATE TABLE IF NOT EXISTS APP_USER (
	USER_ID BIGINT NOT NULL AUTO_INCREMENT,
	USER_EMAIL VARCHAR(255),
	USER_PASSWORD VARCHAR(255),
	CREATION_DATE TIMESTAMP  NOT NULL,
	UPDATING_DATE TIMESTAMP  NOT NULL,
	DELETING_DATE TIMESTAMP,
	PRIMARY KEY(USER_ID)
);

CREATE TABLE IF NOT EXISTS APP_ROLE (
  ROLE_ID int(11) NOT NULL AUTO_INCREMENT,
  USER_ID varchar(45) NOT NULL,
  ROLE varchar(45) NOT NULL,
  CREATION_DATE TIMESTAMP  NOT NULL,
  UPDATING_DATE TIMESTAMP  NOT NULL,
  DELETING_DATE TIMESTAMP,
  PRIMARY KEY (ROLE_ID),
  UNIQUE KEY uni_username_role (ROLE,USER_ID),
  CONSTRAINT fk_user FOREIGN KEY (USER_ID) REFERENCES APP_USER (USER_ID));
