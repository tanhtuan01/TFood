package com.tfood.service;

import java.util.List;

import com.tfood.model.OrderSuccessDTO;

public interface OrderSuccessService {

	void add(OrderSuccessDTO orderSuccessDTO);
	
	List<OrderSuccessDTO> getAll();
	
	int checkOrderCodeExists(String orderCode);
	
	boolean confirmOrder(String orderCode);
	
	String getNote(String orderCode);
	
	int checkStatus(String orderCode);
	
	boolean cancelOrder(String orderCode);
	
	int revenue();
	
	int revenueToDay(int day, int month, int year);
	
	List<OrderSuccessDTO> getMyOrderSuccess(int user);
	
	int getPriceShip(String orderCode);
	
	int getTotalPriceFood(String orderCode);
	
	int getTotalPrice(String orderCode);
	
	String getOrderDate(String orderCode);
	
	int getStatus(String orderCode);
	
	boolean orderSuccess(String orderCode);
	
	List<OrderSuccessDTO> getAllMyOrder(int user);
	
	List<OrderSuccessDTO> getMyOrderCancel(int user);
	
	int quantityOfSuccessOrder();
	
	int quantityOfCancelOrder();
	
	int quantityOfOrder();
	
	int quantityOfAnotherOrder();
}
