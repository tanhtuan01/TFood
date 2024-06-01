package com.tfood.entity;

public class Shipper {

	private int id;
	private String ten;
	private String soDienThoai;
	private String matKhau;
	private double danhGia;
	private String avatar;
	private String thoiGianTao;
	private String thoiGianCapNhat;
	public Shipper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shipper(int id, String ten, String soDienThoai, String matKhau, double danhGia, String avatar,
			String thoiGianTao, String thoiGianCapNhat) {
		super();
		this.id = id;
		this.ten = ten;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
		this.danhGia = danhGia;
		this.avatar = avatar;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public double getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(double danhGia) {
		this.danhGia = danhGia;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	@Override
	public String toString() {
		return "Shipper [id=" + id + ", ten=" + ten + ", soDienThoai=" + soDienThoai + ", matKhau=" + matKhau
				+ ", danhGia=" + danhGia + ", avatar=" + avatar + ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}
	
}
