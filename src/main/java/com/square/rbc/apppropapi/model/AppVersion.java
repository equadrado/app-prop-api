package com.square.rbc.apppropapi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author equadrado
 *
 */
@Entity
@Table(name = "appversion")
public class AppVersion implements Comparable<AppVersion> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String version;

	private String config;

	@NotNull
	private Date creation;

	@NotNull
	private Date lastmodification;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "rbcappid", nullable = false)
	@JsonBackReference(value = "RbcApp_AppVersion")
	private RbcApp rbcApp;

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

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getLastmodification() {
		return lastmodification;
	}

	public void setLastmodification(Date lastmodification) {
		this.lastmodification = lastmodification;
	}

	public RbcApp getRbcApp() {
		return rbcApp;
	}

	public void setRbcApp(RbcApp rbcApp) {
		this.rbcApp = rbcApp;
	}

	@Override
	public int compareTo(AppVersion o) {
		// TODO Auto-generated method stub
	    return lastmodification.compareTo(o.getLastmodification()) > 0 ? -1 : lastmodification.compareTo(o.getLastmodification()) < 0 ? 1 : doSecodaryOrderSort(o);
	}
	
	public int doSecodaryOrderSort(AppVersion o) {
	    return creation.compareTo(o.getCreation()) < 0 ? -1 : creation.compareTo(o.getCreation()) > 0 ? 1 : 0;
	}

}
