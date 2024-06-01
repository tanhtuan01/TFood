package com.tfood.entity;

public class Food {
	
	private int id;
	private	int category;
	private	String tenMon;
	private	String title;
	private	int gia;
	private	int giamGia;
	private	int giaMoi;
	private	String img;
	private String moTa;
	private	int daBan;
	private	String thoiGianTao;
	private	String thoiGianCapNhat;
	private int trangThai;
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTenMon() {
		return tenMon;
	}
	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(int giamGia) {
		this.giamGia = giamGia;
	}
	public int getGiaMoi() {
		return giaMoi;
	}
	public void setGiaMoi(int giaMoi) {
		this.giaMoi = giaMoi;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getDaBan() {
		return daBan;
	}
	public void setDaBan(int daBan) {
		this.daBan = daBan;
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
	
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", category=" + category + ", tenMon=" + tenMon + ", title=" + title + ", gia=" + gia
				+ ", giamGia=" + giamGia + ", giaMoi=" + giaMoi + ", img=" + img + ", moTa=" + moTa + ", daBan=" + daBan
				+ ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat=" + thoiGianCapNhat + ", trangThai=" + trangThai
				+ "]";
	}
	public Food(int id, int category, String tenMon, String title, int gia, int giamGia, int giaMoi, String img,
			String moTa, int daBan, String thoiGianTao, String thoiGianCapNhat, int trangThai) {
		super();
		this.id = id;
		this.category = category;
		this.tenMon = tenMon;
		this.title = title;
		this.gia = gia;
		this.giamGia = giamGia;
		this.giaMoi = giaMoi;
		this.img = img;
		this.moTa = moTa;
		this.daBan = daBan;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianCapNhat = thoiGianCapNhat;
		this.trangThai = trangThai;
	}
	
}
