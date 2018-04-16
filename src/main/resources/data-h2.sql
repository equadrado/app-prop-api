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
  config TEXT NOT NULL,
  CREATION DATETIME NOT NULL,
  LASTMODIFICATION DATETIME NOT NULL,
  rbcappid INT NOT NULL
);
ALTER TABLE appversion
    ADD FOREIGN KEY (RBCAPPID) 
    REFERENCES rbcapp(id) ;
    
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('credicard qualify', 'App to qualify the client according to annual income');
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('Loan qualify 50K', 'App to qualify the client according to annual income for loans over 50K');
INSERT INTO RBCAPP(NAME , DESCRIPTION ) VALUES('Loan qualify bus', 'App to qualify the bussines client according to annual income for loans over 50K');


INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.1.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.2.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()+10, CURRENT_TIMESTAMP()+10, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('2.2.11', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()+30, CURRENT_TIMESTAMP()+60, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.0.1-Beta', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-60, CURRENT_TIMESTAMP()-30, 1);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.0.1-Beta', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-90, CURRENT_TIMESTAMP()-60, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.10.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-60, CURRENT_TIMESTAMP()-30, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('2.1.7', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-30, CURRENT_TIMESTAMP()-10, 2);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('0.1.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-180, CURRENT_TIMESTAMP()-60, 3);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.3.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-110, CURRENT_TIMESTAMP()-60, 3);
INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
	VALUES('1.9.1', '{"server_servlet_contextPath":"/api","spring_datasource_url":"jdbc:h2:mem:apptest","spring_datasource_username":"sa","spring_datasource_password":"","spring_h2_console_enabled":"true","spring_h2_console_path":"/h2-console"}', CURRENT_TIMESTAMP()-10, CURRENT_TIMESTAMP(), 3);


--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('1.1.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('1.2.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()+10, CURRENT_TIMESTAMP()+10, 1);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('2.2.11', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()+30, CURRENT_TIMESTAMP()+60, 1);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('0.0.1-Beta', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-60, CURRENT_TIMESTAMP()-30, 1);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('0.0.1-Beta', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-90, CURRENT_TIMESTAMP()-60, 2);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('1.10.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-60, CURRENT_TIMESTAMP()-30, 2);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('2.1.7', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-30, CURRENT_TIMESTAMP()-10, 2);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('0.1.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-180, CURRENT_TIMESTAMP()-60, 3);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('1.3.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-110, CURRENT_TIMESTAMP()-60, 3);
--INSERT INTO APPVERSION (VERSION, CONFIG, CREATION, LASTMODIFICATION, RBCAPPID   ) 
--	VALUES('1.9.1', 'rO0ABXNyACljb20uc3F1YXJlLnJiYy5hcHBwcm9wYXBpLm1vZGVsLkFwcENvbmZpZ1kNU8klWDgZAgAJTAAac2VydmVyX3NlcnZsZXRfY29udGV4dFBhdGh0ABJMamF2YS9sYW5nL1N0cmluZztMACNzcHJpbmdfZGF0YXNvdXJjZV9kcml2ZXJfY2xhc3NfbmFtZXEAfgABTAAlc3ByaW5nX2RhdGFzb3VyY2VfaW5pdGlhbGl6YXRpb25fbW9kZXEAfgABTAAac3ByaW5nX2RhdGFzb3VyY2VfcGFzc3dvcmRxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3BsYXRmb3JtcQB+AAFMABVzcHJpbmdfZGF0YXNvdXJjZV91cmxxAH4AAUwAGnNwcmluZ19kYXRhc291cmNlX3VzZXJuYW1lcQB+AAFMABlzcHJpbmdfaDJfY29uc29sZV9lbmFibGVkcQB+AAFMABZzcHJpbmdfaDJfY29uc29sZV9wYXRocQB+AAF4cHQABC9hcGlwcHQAAHB0ABNqZGJjOmgyOm1lbTphcHB0ZXN0dAACc2F0AAR0cnVldAALL2gyLWNvbnNvbGU=', CURRENT_TIMESTAMP()-10, CURRENT_TIMESTAMP(), 3);
