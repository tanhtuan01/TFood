package com.tfood.model;

public class CartSubDTO {

	private int id;
	private int user;
	private int food;
	private int soLuong;
	private int gia;
	private int tongTien;
	private String thoiGianTao;
	private String thoiGianCapNhat;
	private String img;
	private String tenMon;
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(String thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public String getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}
	public void setThoiGianCapNhat(String thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public CartSubDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartSubDTO(int id, int user, int food, int soLuong, int gia, int tongTien, String thoiGianTao,
			String thoiGianCapNhat) {
		super();
		this.id = id;
		this.user = user;
		this.food = food;
		this.soLuong = soLuong;
		this.gia = gia;
		this.tongTien = tongTien;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	@Override
	public String toString() {
		return "CartSubDTO [id=" + id + ", user=" + user + ", food=" + food + ", soLuong=" + soLuong + ", gia=" + gia
				+ ", tongTien=" + tongTien + ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat=" + thoiGianCapNhat
				+ "]";
	}
}
