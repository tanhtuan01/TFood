package com.tfood.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfood.dao.AddressDao;
import com.tfood.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDao addressDao;

	@Override
	public double getDistance(String districtValue, String wardValue) {
		// TODO Auto-generated method stub
		return addressDao.getDistance(districtValue, wardValue);
	}

	@Override
	public String getDistrictName(String districtValue) {
		// TODO Auto-generated method stub
		return addressDao.getDistrictName(districtValue);
	}

	@Override
	public String getWardName(String districtValue, String wardValue) {
		// TODO Auto-generated method stub
		return addressDao.getWardName(districtValue, wardValue);
	}

	@Override
	public String getDistrictValue(String orderCode) {
		// TODO Auto-generated method stub
		return addressDao.getDistrictValue(orderCode);
	}

	@Override
	public String getWardValue(String orderCode) {
		// TODO Auto-generated method stub
		return addressDao.getWardValue(orderCode);
	}

	@Override
	public String getAddress(String orderCode) {
		// TODO Auto-generated method stub
		return addressDao.getAddress(orderCode);
	}
	
}
