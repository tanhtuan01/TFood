package com.tfood.dao;

import java.util.List;

import com.tfood.entity.OrderSuccess;

public interface OrderSuccessDao {

	void add(OrderSuccess orderSuccess);

	List<OrderSuccess> getAll();
	
	int checkOrderCodeExists(String orderCode);
	
	boolean confirmOrder(String orderCode);
	
	String getNote(String orderCode);
	
	int checkStatus(String orderCode);
	
	boolean cancelOrder(String orderCode);
	
	int revenue();
	
	int revenueToDay(int day, int month, int year);
	
	List<OrderSuccess> getMyOrderSuccess(int user);
	
	int getPriceShip(String orderCode);
	
	int getTotalPriceFood(String orderCode);
	
	int getTotalPrice(String orderCode);
	
	String getOrderDate(String orderCode);
	
	int getStatus(String orderCode);
	
	boolean orderSuccess(String orderCode);
	
	List<OrderSuccess> getAllMyOrder(int user);
	
	List<OrderSuccess> getMyOrderCancel(int user);
	
	int quantityOfSuccessOrder();
	
	int quantityOfCancelOrder();
	
	int quantityOfOrder();
	
	int quantityOfAnotherOrder();
}
