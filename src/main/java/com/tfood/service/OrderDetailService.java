package com.tfood.service;

import java.util.List;

import com.tfood.model.OrderDetailDTO;

public interface OrderDetailService {

	void addToCheckOut(OrderDetailDTO orderDetailDTO);

	int checkInOrderDetail(int id_orders);
	
	List<OrderDetailDTO> list(int user);
	
	boolean deleteItemOrderDetail(int cartid, int userid);
	
	int countQuantity(int user);
	
	int totalPrice(int user);
	
	void updatePayment(OrderDetailDTO orderDetailDTO);
	
	List<OrderDetailDTO> getAll();
	
	void confirmOrder(OrderDetailDTO orderDetailDTO);
	
	List<OrderDetailDTO> waitForShip();
	
	int countOrderSucess();

	List<OrderDetailDTO> orderSuccess(int id);
	
	List<OrderDetailDTO> waitForShipByCode();
}
