package com.tfood.entity;

public class Revenua {
	private int id;
	private int order_detail_id;
	private int price;
	
	public Revenua() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revenua(int id, int order_detail_id, int price) {
		super();
		this.id = id;
		this.order_detail_id = order_detail_id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Revenua [ind=" + id + ", order_detail_id=" + order_detail_id + ", price=" + price + "]";
	}
	
	
}
