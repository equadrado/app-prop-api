package com.square.rbc.apppropapi.dto;

import java.util.Date;

import com.square.rbc.apppropapi.model.AppConfig;

/**
 * 
 * @author equadrado
 *
 */
public class AppVersionDTO {

	private Long id;
	private String version;
	private AppConfig config;
	private Date creationDate;
	private Date lastModificationDate;
	private Long rbcappid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public AppConfig getConfig() {
		return config;
	}

	public void setConfig(AppConfig config) {
		this.config = config;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public Long getRbcappid() {
		return rbcappid;
	}

	public void setRbcappid(Long rbcappid) {
		this.rbcappid = rbcappid;
	}

}
