package com.tfood.dao;

import java.util.List;

import com.tfood.entity.OrderDetailFood;

public interface OrderDetailFoodDao {

	void add(OrderDetailFood orderDetailFood);
	
	List<OrderDetailFood> getAll(String orderCode);
	
	//List<OrderDetailFood> getByMyOrderCode(String orderCode);
}
