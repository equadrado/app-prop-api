package com.square.rbc.apppropapi.model;

import java.io.Serializable;

/**
 * 
 * @author equadrado
 *
 * This Class is used to wrap the JSON with all properties e values
 * All fields are not mandatory, therefore an object may contain all or none of its properties
 * 
 */
public class AppConfig implements Serializable {

	private String server_servlet_contextPath;
	private String spring_datasource_url;
	private String spring_datasource_username;
	private String spring_datasource_password;
	private String spring_datasource_driver_class_name;
	private String spring_datasource_initialization_mode;
	private String spring_datasource_platform;
	private String spring_h2_console_enabled;
	private String spring_h2_console_path;

	public String getServer_servlet_contextPath() {
		return server_servlet_contextPath;
	}

	public void setServer_servlet_contextPath(String server_servlet_contextPath) {
		this.server_servlet_contextPath = server_servlet_contextPath;
	}

	public String getSpring_datasource_url() {
		return spring_datasource_url;
	}

	public void setSpring_datasource_url(String spring_datasource_url) {
		this.spring_datasource_url = spring_datasource_url;
	}

	public String getSpring_datasource_username() {
		return spring_datasource_username;
	}

	public void setSpring_datasource_username(String spring_datasource_username) {
		this.spring_datasource_username = spring_datasource_username;
	}

	public String getSpring_datasource_password() {
		return spring_datasource_password;
	}

	public void setSpring_datasource_password(String spring_datasource_password) {
		this.spring_datasource_password = spring_datasource_password;
	}

	public String getSpring_datasource_driver_class_name() {
		return spring_datasource_driver_class_name;
	}

	public void setSpring_datasource_driver_class_name(String spring_datasource_driver_class_name) {
		this.spring_datasource_driver_class_name = spring_datasource_driver_class_name;
	}

	public String getSpring_datasource_initialization_mode() {
		return spring_datasource_initialization_mode;
	}

	public void setSpring_datasource_initialization_mode(String spring_datasource_initialization_mode) {
		this.spring_datasource_initialization_mode = spring_datasource_initialization_mode;
	}

	public String getSpring_datasource_platform() {
		return spring_datasource_platform;
	}

	public void setSpring_datasource_platform(String spring_datasource_platform) {
		this.spring_datasource_platform = spring_datasource_platform;
	}

	public String getSpring_h2_console_enabled() {
		return spring_h2_console_enabled;
	}

	public void setSpring_h2_console_enabled(String spring_h2_console_enabled) {
		this.spring_h2_console_enabled = spring_h2_console_enabled;
	}

	public String getSpring_h2_console_path() {
		return spring_h2_console_path;
	}

	public void setSpring_h2_console_path(String spring_h2_console_path) {
		this.spring_h2_console_path = spring_h2_console_path;
	}

}
