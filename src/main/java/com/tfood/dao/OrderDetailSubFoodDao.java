package com.tfood.dao;

import java.util.List;

import com.tfood.entity.OrderDetailSubFood;

public interface OrderDetailSubFoodDao {

	void add(OrderDetailSubFood orderDetailSubFood);
	
	List<OrderDetailSubFood> getAll(String orderCode);
	
	//List<OrderDetailSubFood> getByMyOrderCode(String orderCode);
}
