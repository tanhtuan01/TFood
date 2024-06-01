package com.tfood.entity;

public class OrderSuccess {

	private int id;
	private int user;
	private int totalPriceFood;
	private int priceShip;
	private int totalPrice;
	private String orderCode;
	private String date;
	private String note;
	private int status;
	private String address;
	private String districtValue;
	private String wardValue;
	private String userName;
	private String districtName;
	private String wardName;
	private String phone;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrictValue() {
		return districtValue;
	}
	public void setDistrictValue(String districtValue) {
		this.districtValue = districtValue;
	}
	public String getWardValue() {
		return wardValue;
	}
	public void setWardValue(String wardValue) {
		this.wardValue = wardValue;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public int getTotalPriceFood() {
		return totalPriceFood;
	}
	public void setTotalPriceFood(int totalPriceFood) {
		this.totalPriceFood = totalPriceFood;
	}
	public int getPriceShip() {
		return priceShip;
	}
	public void setPriceShip(int priceShip) {
		this.priceShip = priceShip;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public OrderSuccess(int id, int user, int totalPriceFood, int priceShip, int totalPrice, String orderCode,
			String date, String note, int status, String address, String districtValue, String wardValue) {
		super();
		this.id = id;
		this.user = user;
		this.totalPriceFood = totalPriceFood;
		this.priceShip = priceShip;
		this.totalPrice = totalPrice;
		this.orderCode = orderCode;
		this.date = date;
		this.note = note;
		this.status = status;
		this.address = address;
		this.districtValue = districtValue;
		this.wardValue = wardValue;
	}
	public OrderSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "OrderSuccess [id=" + id + ", user=" + user + ", totalPriceFood=" + totalPriceFood + ", priceShip="
				+ priceShip + ", totalPrice=" + totalPrice + ", orderCode=" + orderCode + ", date=" + date + ", note="
				+ note + ", status=" + status + ", address=" + address + ", districtValue=" + districtValue
				+ ", wardValue=" + wardValue + "]";
	}
	public String Status() {
		if(this.status == 0) {
			return "Chưa xác nhận";
		}
		if(this.status == 1) {
			return "Đang giao";
		}
		if(this.status == 2) {
			return "Giao thành công";
		}else {
			return "Đã hủy";
		}
	}
	
	public String setStyle() {
		if(this.status > 2) {
			return "btn btn-dangder";
		}else {
			return "btn btn-primary";
		}
	}
}
