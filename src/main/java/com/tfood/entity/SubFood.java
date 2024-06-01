package com.tfood.entity;

public class SubFood {

	private int id;
	private int category;
	private String tenMon;
	private int gia;
	private String img;
	private String thoiGianTao;
	private String thoiGianCapNhat;
	private String moTa;
	
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
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
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public SubFood() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubFood [id=" + id + ", category=" + category + ", tenMon=" + tenMon + ", gia=" + gia + ", img=" + img
				+ ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat=" + thoiGianCapNhat + ", moTa=" + moTa + "]";
	}
}
