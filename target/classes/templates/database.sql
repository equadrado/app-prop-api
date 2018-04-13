DROP TABLE IF EXISTS rbcapp;

CREATE TABLE rbcapp (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  description VARCHAR(300) DEFAULT NULL
);

DROP TABLE IF EXISTS appversion;

CREATE TABLE appversion (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  version VARCHAR(20) NOT NULL,
  config CLOB NOT NULL,
  CREATION DATE NOT NULL,
  LASTMODIFICATION DATE NOT NULL,
  rbcappid INT NOT NULL
);
ALTER TABLE appversion
    ADD FOREIGN KEY (RBCAPPID) 
    REFERENCES rbcapp(id) ;
    
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('credicard qualify', 'App to qualify the client according to annual income');
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('Loan qualify 50K', 'App to qualify the client according to annual income for loans over 50K');
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('Loan qualify bus', 'App to qualify the bussines client according to annual income for loans over 50K');

INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.1.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE(), CURRENT_DATE(), 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.2.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()+10, CURRENT_DATE()+10, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('2.2.11', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()+30, CURRENT_DATE()+60, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.0.1-Beta', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-60, CURRENT_DATE()-30, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.0.1-Beta', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-90, CURRENT_DATE()-60, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.10.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-60, CURRENT_DATE()-30, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('2.1.7', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-30, CURRENT_DATE()-10, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.1.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-180, CURRENT_DATE()-60, 3);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.3.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-110, CURRENT_DATE()-60, 3);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.9.1', '{"prop1":"value1", "prop2":"value2", "prop3":"value3", "prop4":"value4", "prop5":"value5"}', CURRENT_DATE()-10, CURRENT_DATE(), 3);
