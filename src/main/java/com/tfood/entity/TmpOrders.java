package com.tfood.entity;

public class TmpOrders {
	private int user_id;
	private int order_id;
	private int quantity;
	private int price;
	
	public TmpOrders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TmpOrders(int user_id, int order_id, int quantity, int price) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.quantity = quantity;
		this.price = price;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TmpOrders [user_id=" + user_id + ", order_id=" + order_id + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
	
	
}
