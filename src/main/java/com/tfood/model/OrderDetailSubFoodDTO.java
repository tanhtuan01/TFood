package com.tfood.model;

public class OrderDetailSubFoodDTO {

	private int id;
	private int user;
	private int food;
	private int quantity;
	private int totalprice;
	private String date;
	private String orderCode;
	private String foodName;
	private String img;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public OrderDetailSubFoodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailSubFoodDTO(int id, int user, int food, int quantity, int totalprice, String date, String orderCode) {
		super();
		this.id = id;
		this.user = user;
		this.food = food;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.date = date;
		this.orderCode = orderCode;
	}
	@Override
	public String toString() {
		return "OrderDetailSubFoodDTO [id=" + id + ", user=" + user + ", food=" + food + ", quantity=" + quantity
				+ ", totalprice=" + totalprice + ", date=" + date + ", orderCode=" + orderCode + "]";
	}
	
}
