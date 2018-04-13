package com.square.rbc.apppropapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author equadrado
 *
 */
@Entity
@Table(name = "rbcapp")
public class RbcApp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String description;

	@OneToMany(mappedBy = "rbcApp", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference(value = "RbcApp_AppVersion")
	private List<AppVersion> appVersions;

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

	public List<AppVersion> getAppVersions() {
		return appVersions;
	}

	public void setAppVersions(List<AppVersion> appVersions) {
		this.appVersions = appVersions;
	}

}
