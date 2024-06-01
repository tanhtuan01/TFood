package com.tfood.dao;

public interface AddressDao {

	double getDistance(String districtValue, String wardValue);
	
	String getDistrictName(String districtValue);
	
	String getWardName(String districtValue, String wardValue);
	
	String getDistrictValue(String orderCode);
	
	String getWardValue(String orderCode);
	
	String getAddress(String orderCode);
}
