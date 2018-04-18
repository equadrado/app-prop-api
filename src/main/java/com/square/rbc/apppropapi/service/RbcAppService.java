package com.square.rbc.apppropapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.square.rbc.apppropapi.dto.AppVersionDTO;
import com.square.rbc.apppropapi.dto.RbcAppDTO;
import com.square.rbc.apppropapi.exception.InvalidPathParameterException;
import com.square.rbc.apppropapi.exception.InvalidTextPropertySizeException;
import com.square.rbc.apppropapi.exception.MandatoryFieldNotProvidedException;
import com.square.rbc.apppropapi.exception.NewObjectCantBeNullException;
import com.square.rbc.apppropapi.exception.ObjectNotFoundException;
import com.square.rbc.apppropapi.model.AppConfig;
import com.square.rbc.apppropapi.model.AppVersion;
import com.square.rbc.apppropapi.model.RbcApp;
import com.square.rbc.apppropapi.repository.RbcAppRepository;
import com.square.rbc.apppropapi.util.Utility;

/**
 * 
 * @author equadrado
 *
 */
@Service
public class RbcAppService {

	@Autowired
	private RbcAppRepository rbcAppRepository;

	public List<RbcApp> findAll() {
		return rbcAppRepository.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return An RbcApp (Application) with the ID 
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	public RbcApp findById(Long id) throws ObjectNotFoundException, InvalidPathParameterException {
		if (id <= 0) {
			throw new InvalidPathParameterException("APP_ID_IVALID");
		}
		
		Optional<RbcApp> rbcApp = rbcAppRepository.findById(id);
		
		if (!rbcApp.isPresent()) {
			throw new ObjectNotFoundException("RBC_APP", id.toString());
		}
		
		return rbcApp.get();
	}
	
	/**
	 *
	 * @param id (Application ID)
	 * @return A List with all versions and configurations linked to that Application 	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	@Transactional(readOnly=true)
	public List<AppVersionDTO> getConfigByAppId(Long id) throws ObjectNotFoundException, InvalidPathParameterException {
		
		RbcApp rbcApp = this.findById(id);
		if (rbcApp == null) {
			throw new ObjectNotFoundException("RBC_APP", id.toString());
		}
		
		if (rbcApp.getAppVersions().isEmpty()) {
			throw new ObjectNotFoundException("APP_VER", id.toString());
		}
		
		// It's not ncessary call it again
		// List<AppVersion> appVersionList = rbcAppRepository.findRbcAppByIdOrdered(id).getAppVersions();
		List<AppVersion> appVersionList = rbcApp.getAppVersions();
		
		// change the order to descend
		AppVersion.ascend = false;
		// Sort the list
		Collections.sort(appVersionList); 	
		// if the descend order was not implemented, could revese the order using method Collections.reverse()
		//Collections.reverse(appVersionList);
		
		List<AppVersionDTO> appVerDTOList = new ArrayList<AppVersionDTO>();
		
		for(AppVersion app: appVersionList) {
			AppVersionDTO dto = new AppVersionDTO();
			
			dto.setCreationDate(app.getCreation());
			dto.setId(app.getId());
			dto.setVersion(app.getVersion());
			dto.setLastModificationDate(app.getLastmodification());
			
			// Transform the String into AppConfig Object
			
			// using Base64 library			
			// dto.setConfig((AppConfig) Utility.stringToSerializable(app.getConfig()));
			
			// Using gson library
			dto.setConfig((AppConfig) Utility.jsonToObject(app.getConfig(), AppConfig.class));
			
			appVerDTOList.add(dto);
		}
		
		return appVerDTOList;
	}

	/**
	 * 
	 * @param dto (RbcAppDTO Object)
	 * @return If succeed, return the new object created or updated 
	 * @throws NewObjectCantBeNullException
	 * @throws MandatoryFieldNotProvidedException
	 * @throws InvalidTextPropertySizeException
	 */
	public RbcApp saveRbcApp(RbcAppDTO dto)
			throws NewObjectCantBeNullException, MandatoryFieldNotProvidedException, InvalidTextPropertySizeException {
		if (dto == null) {
			throw new NewObjectCantBeNullException("RBC_APP");
		}

		if (dto.getName().isEmpty()) {
			throw new MandatoryFieldNotProvidedException("RBC_APP", "NAME");
		}
		
		return rbcAppRepository.save(RbcAppDTO.bind(dto));
	}

	/**
	 * 
	 * @param id
	 * @return true if the object is identified and excluded
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	public boolean deleteRbcApp(Long id) throws ObjectNotFoundException, InvalidPathParameterException {
		if (id > 0) {
			throw new InvalidPathParameterException("ID");
		}
		Optional<RbcApp> rbcApp = rbcAppRepository.findById(id);
		if (!rbcApp.isPresent()) {
			throw new ObjectNotFoundException("RBC_APP", id.toString());
		}

		rbcAppRepository.delete(rbcApp.get());
		
		return true;
	}
}
