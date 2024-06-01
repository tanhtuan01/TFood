package com.tfood.model;

public class OrderDetailDTO {

	private int id;
	private int user_id;
	private int orders_id;
	private String name;
	private String food_name;
	private String phone_number;
	private String email;
	private String address;
	private int quantity;
	private int price;
	private int payment;
	private int status;
	private int shipper;
	private String created_at;
	private String updated_at;
	private String avatar;
	private int food_id;
	private int food_cate_id;
	private int code;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getFood_cate_id() {
		return food_cate_id;
	}

	public void setFood_cate_id(int food_cate_id) {
		this.food_cate_id = food_cate_id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public OrderDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public OrderDetailDTO(int id, int user_id, int orders_id, String name, String food_name, String phone_number,
			String email, String address, int quantity, int price, int payment, int status, int shipper,
			String created_at, String updated_at, String avatar, int food_id, int food_cate_id, int code) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.orders_id = orders_id;
		this.name = name;
		this.food_name = food_name;
		this.phone_number = phone_number;
		this.email = email;
		this.address = address;
		this.quantity = quantity;
		this.price = price;
		this.payment = payment;
		this.status = status;
		this.shipper = shipper;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.avatar = avatar;
		this.food_id = food_id;
		this.food_cate_id = food_cate_id;
		this.code = code;
	}
	

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getShipper() {
		return shipper;
	}

	public void setShipper(int shipper) {
		this.shipper = shipper;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "OrderDetailDTO [id=" + id + ", user_id=" + user_id + ", orders_id=" + orders_id + ", name=" + name
				+ ", food_name=" + food_name + ", phone_number=" + phone_number + ", email=" + email + ", address="
				+ address + ", quantity=" + quantity + ", price=" + price + ", payment=" + payment + ", status="
				+ status + ", shipper=" + shipper + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", avatar=" + avatar + ", food_id=" + food_id + ", food_cate_id=" + food_cate_id + ", code=" + code
				+ "]";
	}

	
}
