package com.tfood.service;

import com.tfood.model.RevenuaDTO;

public interface RevenuaService {

	void addPrice(RevenuaDTO revenuaDTO);
	
	int price();
}
