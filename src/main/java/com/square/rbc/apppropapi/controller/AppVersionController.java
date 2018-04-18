package com.square.rbc.apppropapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.square.rbc.apppropapi.model.AppConfig;
import com.square.rbc.apppropapi.service.AppVersionService;

/**
 * 
 * @author equadrado
 *
 */
@RestController
@RequestMapping("/api/v1/")
public class AppVersionController {

	@Autowired
	AppVersionService appVersionService;

	/**
	 * 
	 * @param appCode
	 * @param version
	 * @return An AppConfig object, with the configuration for the version
	 *         passed as parameter and for the Application with the ID passed as
	 *         parameter (appCode)
	 * @throws Exception
	 */
	@GetMapping(value = "{appCode}/config/{version}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppConfig getAppByIdAndVersion(@PathVariable(name = "appCode") Long appCode,
			@PathVariable(name = "version") String version) throws Exception {
		return appVersionService.findByIdAndByVersion(appCode, version);
	}

	/**
	 * 
	 * @param appCode
	 * @param version
	 * @param config
	 * @return True if the AppVersion (config parameter) object was successful
	 *         stored in the DB
	 * @throws Exception
	 */
	@PostMapping(value = "{appCode}/config/{version}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean createAppVersion(@PathVariable(name = "appCode") Long appCode,
			@PathVariable(name = "version") String version, @RequestBody() AppConfig config) throws Exception {
		return appVersionService.saveAppVersion(appCode, version, config);
	}

	/**
	 * 
	 * @param appCode
	 * @param version
	 * @param config
	 * @return True if the AppVersion (config parameter) object was successful
	 *         stored in the DB
	 * @throws Exception
	 */
	@PutMapping(value = "{appCode}/config/{version}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean updateAppVersion(@PathVariable(name = "appCode") Long appCode,
			@PathVariable(name = "version") String version, @RequestBody() AppConfig config) throws Exception {
		return appVersionService.saveAppVersion(appCode, version, config);
	}

	/**
	 * 
	 * @param appCode
	 * @throws Exception
	 */
	@DeleteMapping("{appCode}")
	public void deleteAppVersion(@PathVariable(name = "appCode") Long appCode) throws Exception {
		appVersionService.deleteAppVersion(appCode);
	}

}
