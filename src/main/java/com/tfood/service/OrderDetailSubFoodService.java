package com.tfood.service;

import java.util.List;

import com.tfood.model.OrderDetailSubFoodDTO;

public interface OrderDetailSubFoodService {

	void add(OrderDetailSubFoodDTO orderDetailSubFoodDTO);

	List<OrderDetailSubFoodDTO> getAll(String orderCode);
	
	//List<OrderDetailSubFoodDTO> getByMyOrderCode(String orderCode);
}
