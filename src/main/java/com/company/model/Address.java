package com.company.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "zip_code")
	private String zipCode;
	
	@Column(name = "street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="home_address")
	private String homeAddress;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", street=" + street + ", city=" + city + ", homeAddress=" + homeAddress
				+ "]";
	}
	
}
