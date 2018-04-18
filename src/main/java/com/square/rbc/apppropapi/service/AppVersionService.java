package com.square.rbc.apppropapi.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.square.rbc.apppropapi.exception.InvalidPathParameterException;
import com.square.rbc.apppropapi.exception.InvalidTextPropertySizeException;
import com.square.rbc.apppropapi.exception.MandatoryFieldNotProvidedException;
import com.square.rbc.apppropapi.exception.ObjectNotFoundException;
import com.square.rbc.apppropapi.model.AppConfig;
import com.square.rbc.apppropapi.model.AppVersion;
import com.square.rbc.apppropapi.model.RbcApp;
import com.square.rbc.apppropapi.repository.AppVersionRepository;
import com.square.rbc.apppropapi.util.Utility;

/**
 * 
 * @author equadrado
 *
 */
@Service
public class AppVersionService {

	@Autowired
	AppVersionRepository appVersionRepository;

	@Autowired
	RbcAppService rbcAppService;

	/**
	 * 
	 * @param id
	 * @param version
	 * @return The Application configuration for the Application and Version, acording to ID and version
	 * 			parameters 
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	@Transactional(readOnly=true)
	public AppConfig findByIdAndByVersion(Long id, String version)
			throws ObjectNotFoundException, InvalidPathParameterException {

		if ((id <= 0) || (version.isEmpty())) {
			throw new InvalidPathParameterException("APP_ID_IVALID OR VERSION_INVALID");
		}

		RbcApp rbcApp = rbcAppService.findById(id);

		if (rbcApp == null) {
			throw new ObjectNotFoundException("RBC_APP", id.toString());
		}

		AppVersion appVersion = appVersionRepository.findByVersionAndRbcAppId(version, id);
		
		if (appVersion == null) {
			throw new ObjectNotFoundException("APP_VERSION_ID", version);
		}
		// Using Base64 library
		//AppConfig appConfig = (AppConfig) Utility.stringToSerializable(appVersion.getConfig());

		// Using gson library
		AppConfig appConfig = (AppConfig) Utility.jsonToObject(appVersion.getConfig(), AppConfig.class);
		
		return appConfig;
	}

	/**
	 * 
	 * @param rbcAppId
	 * @param version
	 * @param config
	 * @return True if it save the configuration (config) for the Application and Version
	 * @throws MandatoryFieldNotProvidedException
	 * @throws InvalidTextPropertySizeException
	 * @throws InvalidPathParameterException
	 * @throws ObjectNotFoundException
	 */
	public boolean saveAppVersion(Long rbcAppId, String version, AppConfig config)
			throws MandatoryFieldNotProvidedException, InvalidTextPropertySizeException, 
					InvalidPathParameterException, ObjectNotFoundException {
		
		if (rbcAppId <= 0) {
			throw new InvalidPathParameterException("APP_ID_IVALID");
		}
		if (version.isEmpty()) {
			throw new MandatoryFieldNotProvidedException("APP_VERSION", "VERSION");
		}
		if (config == null) {
			throw new MandatoryFieldNotProvidedException("APP_VERSION", "CONFIG");
		}

		RbcApp rbcApp = rbcAppService.findById(rbcAppId);
		if (rbcApp == null) {
			throw new ObjectNotFoundException("RBC_APP", rbcAppId.toString());
		}

		// To modify an AppVersion, must check if RbcApp ID matches with the URL variable
		AppVersion appVersion = appVersionRepository.findByVersionAndRbcApp(version, rbcApp);

		if (appVersion == null) {
			// To create a new Version Configuration
			appVersion = new AppVersion();
			appVersion.setRbcApp(rbcApp);
			appVersion.setCreation(new Date());
		}
		appVersion.setLastmodification(new Date());
		appVersion.setVersion(version);
		appVersion.setLastmodification(new Date());
		// Transform the AppConfig Object into String
//		appVersion.setConfig(Utility.serializableToString(config));
		appVersion.setConfig(Utility.objectToJson(config));

		appVersionRepository.save(appVersion);

		return true;
	}

	/**
	 * 
	 * @param id
	 * @return true if the object was found and excluded
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	public boolean deleteAppVersion(Long id) throws ObjectNotFoundException, InvalidPathParameterException {
		if (id > 0) {
			throw new InvalidPathParameterException("ID");
		}

		Optional<AppVersion> appVer = appVersionRepository.findById(id);

		if (!appVer.isPresent()) {
			throw new ObjectNotFoundException("APP_VERSION", id.toString());
		}

		appVersionRepository.delete(appVer.get());

		return true;
	}

}
