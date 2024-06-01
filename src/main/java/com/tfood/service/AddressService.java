package com.tfood.service;

public interface AddressService {

	double getDistance(String districtValue, String wardValue);
	
	String getDistrictName(String districtValue);
	
	String getWardName(String districtValue, String wardValue);
	
	String getDistrictValue(String orderCode);
	
	String getWardValue(String orderCode);
	
	String getAddress(String orderCode);
	
}
