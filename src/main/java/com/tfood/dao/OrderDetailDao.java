package com.tfood.dao;

import java.util.List;

import com.tfood.entity.OrderDetail;

public interface OrderDetailDao {

	void addToCheckOut(OrderDetail orderDetail);
	
	int checkInOrderDetail(int id_orders);
	
	List<OrderDetail> list(int user);
	
	boolean deleteItemOrderDetail(int cartid, int userid);
	
	int countQuantity(int user);
	
	int totalPrice(int user);
	
	void updatePayment(OrderDetail orderDetail);
	
	List<OrderDetail> getAll();
	
	void confirmOrder(OrderDetail orderDetail);
	
	List<OrderDetail> waitForShip();
	
	int countOrderSucess();
	
	List<OrderDetail> orderSuccess(int id);
	
	List<OrderDetail> waitForShipByCode();
}
