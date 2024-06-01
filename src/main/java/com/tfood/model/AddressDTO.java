package com.tfood.model;

public class AddressDTO {

	private String districtValue;
	private String wardValue;
	private Double distance;
	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressDTO(String districtValue, String wardValue, Double distance) {
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
