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
	public static boolean ascend = true; // true for ascend order, false for descend
	
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
	public int compareTo(AppVersion obj) {
//	    return lastmodification.compareTo(obj.getLastmodification()) > 0 ? -1 : lastmodification.compareTo(obj.getLastmodification()) < 0 ? 1 : doSecodaryOrderSort(obj);
		return doPrimaryOrderSort(obj);
	}
	
	/**
	 * order by the first property (in this case, "lastmodification")
	 * @param other
	 * @return
	 */
	public int doPrimaryOrderSort(AppVersion other) {
		int base = ascend ? 1 : -1; 
	    return this.lastmodification.compareTo(other.getLastmodification()) > 0 ? base : this.lastmodification.compareTo(other.getLastmodification()) < 0 ? -1*base : doSecodaryOrderSort(other);
	}
	
	/**
	 * order by a second property (in this case, "creation")
	 * @param other
	 * @return
	 */
	public int doSecodaryOrderSort(AppVersion other) {
		int base = ascend ? 1 : -1; 
	    return this.creation.compareTo(other.getCreation()) > 0 ? base : this.creation.compareTo(other.getCreation()) <= 0 ? -1*base : 0;
	}

}
