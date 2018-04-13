package com.square.rbc.apppropapi.dto;

import com.square.rbc.apppropapi.exception.InvalidTextPropertySizeException;
import com.square.rbc.apppropapi.model.RbcApp;

/**
 * 
 * @author equadrado
 *
 */
public class RbcAppDTO {

	private Long id;
	private String name;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static RbcApp bind(RbcAppDTO dto) throws InvalidTextPropertySizeException {
		if (dto.getName().length() > 20) {
			throw new InvalidTextPropertySizeException("RBC_APP", "NAME");
		} else if (dto.getDescription().length() > 300) {
			throw new InvalidTextPropertySizeException("RBC_APP", "DESCRIPTION");
		}

		RbcApp rbcapp = new RbcApp();

		rbcapp.setId(dto.getId());
		rbcapp.setName(dto.getName());
		rbcapp.setDescription(dto.getDescription());

		return rbcapp;
	}

}
