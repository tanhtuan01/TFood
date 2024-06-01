package com.tfood.entity;

public class User {

	private int id;
	private String tenNguoiDung;
	private String soDienThoai;
	private String matKhau;
	private String email;
	private String diaChi;
	private String avatar;
	private int trangThai;
	private String thoiGianTao;
	private String thoiGianCapNhat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenNguoiDung() {
		return tenNguoiDung;
	}
	public void setTenNguoiDung(String tenNguoiDung) {
		this.tenNguoiDung = tenNguoiDung;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
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
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", tenNguoiDung=" + tenNguoiDung + ", soDienThoai=" + soDienThoai + ", matKhau="
				+ matKhau + ", email=" + email + ", diaChi=" + diaChi + ", avatar=" + avatar + ", trangThai="
				+ trangThai + ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}
}