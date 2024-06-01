package com.tfood.model;

public class FoodDTO {
	private int id;
	private	int category;
	private	String tenMon;
	private	String title;
	private	int gia;
	private	int giamGia;
	private	int giaMoi;
	private	String img;
	private	int daBan;
	private String moTa;
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
	public FoodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	@Override
	public String toString() {
		return "FoodDTO [id=" + id + ", category=" + category + ", tenMon=" + tenMon + ", title=" + title + ", gia="
				+ gia + ", giamGia=" + giamGia + ", giaMoi=" + giaMoi + ", img=" + img + ", daBan=" + daBan + ", moTa="
				+ moTa + ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat=" + thoiGianCapNhat + ", trangThai="
				+ trangThai + "]";
	}
	
	public String setStatus() {
		return (this.trangThai == 0) ? "display:none" : "";
	}
	
}
