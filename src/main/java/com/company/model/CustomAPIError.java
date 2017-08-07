package com.company.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class CustomAPIError
implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String cause;
	private HttpStatus status;

	public CustomAPIError() {
	}

	public CustomAPIError(String name, String cause, HttpStatus status) {
		super();
		this.name = name;
		this.cause = cause;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomAPIError [name=" + name + ", cause=" + cause + ", status=" + status + "]";
	}

}
