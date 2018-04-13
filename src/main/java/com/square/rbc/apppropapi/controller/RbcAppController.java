package com.square.rbc.apppropapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.square.rbc.apppropapi.dto.AppVersionDTO;
import com.square.rbc.apppropapi.dto.RbcAppDTO;
import com.square.rbc.apppropapi.exception.InvalidPathParameterException;
import com.square.rbc.apppropapi.exception.InvalidTextPropertySizeException;
import com.square.rbc.apppropapi.exception.MandatoryFieldNotProvidedException;
import com.square.rbc.apppropapi.exception.NewObjectCantBeNullException;
import com.square.rbc.apppropapi.exception.ObjectNotFoundException;
import com.square.rbc.apppropapi.model.RbcApp;
import com.square.rbc.apppropapi.service.RbcAppService;

/**
 * 
 * @author equadrado
 *
 */
@RestController
@RequestMapping("/api/v1")
public class RbcAppController {

	@Autowired
	RbcAppService rbcAppService;

	/**
	 * 
	 * @return A List with all register of applications registered and its versions
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<RbcApp> getAll() throws ObjectNotFoundException, InvalidPathParameterException {
		return rbcAppService.findAll();
	}

	/**
	 * 
	 * @param appCode (Application ID)
	 * @return A List with all versions and configurations linked to that Application 
	 * @throws ObjectNotFoundException
	 * @throws InvalidPathParameterException
	 */
	@GetMapping(value="/{appCode}/config", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE )
	public List<AppVersionDTO> getAppById(@PathVariable(name = "appCode") Long appCode)
			throws ObjectNotFoundException, InvalidPathParameterException {
		return rbcAppService.getConfigByAppId(appCode);
	}

	/**
	 * 
	 * @param dto (RbcAppDTO Object)
	 * @return If succeed, return the new object created or updated 
	 * @throws NewObjectCantBeNullException
	 * @throws MandatoryFieldNotProvidedException
	 * @throws InvalidTextPropertySizeException
	 */
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public RbcApp createRbcApp(@RequestBody() RbcAppDTO dto)
			throws NewObjectCantBeNullException, MandatoryFieldNotProvidedException, InvalidTextPropertySizeException {
		return rbcAppService.saveRbcApp(dto);
	}

	/**
	 * 
	 * @param appCode
	 * @param dto (RbcAppDTO Object)
	 * @return If succeed, return the new object created or updated 
	 * @throws NewObjectCantBeNullException
	 * @throws MandatoryFieldNotProvidedException
	 * @throws InvalidTextPropertySizeException
	 */
	@PutMapping(value="/{appCode}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public RbcApp updateRbcApp(@PathVariable(name = "appCode") Long appCode, @RequestBody() RbcAppDTO dto)
			throws NewObjectCantBeNullException, MandatoryFieldNotProvidedException, InvalidTextPropertySizeException {
		return rbcAppService.saveRbcApp(dto);
	}

}
