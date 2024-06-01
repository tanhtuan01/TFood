package com.tfood.service;

import java.util.List;

import com.tfood.model.OrderDetailFoodDTO;

public interface OrderDetailFoodService {

	void add(OrderDetailFoodDTO orderDetailFoodDTO);

	List<OrderDetailFoodDTO> getAll(String orderCode);
	
	//List<OrderDetailFoodDTO> getByMyOrderCode(String orderCode);
}
