package com.tfood.entity;

public class Address {

	private String districtValue;
	private String wardValue;
	private Double distance;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String districtValue, String wardValue, Double distance) {
		super();
		this.districtValue = districtValue;
		this.wardValue = wardValue;
		this.distance = distance;
	}
	public String getDistrictValue() {
		return districtValue;
	}
	public void setDistrictValue(String districtValue) {
		this.districtValue = districtValue;
	}
	public String getWardValue() {
		return wardValue;
	}
	public void setWardValue(String wardValue) {
		this.wardValue = wardValue;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
}
