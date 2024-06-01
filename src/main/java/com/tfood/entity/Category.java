package com.tfood.entity;

public class Category {

	private int id;
	private String tenDanhMuc;
	private String title;
	private int thuTuHienThi;
	private String img;
	private String thoiGianTao;
	private String thoiGianCapNhat;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getThuTuHienThi() {
		return thuTuHienThi;
	}
	public void setThuTuHienThi(int thuTuHienThi) {
		this.thuTuHienThi = thuTuHienThi;
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
	public Category(int id, String tenDanhMuc, String title, int thuTuHienThi, String img, String thoiGianTao,
			String thoiGianCapNhat) {
		super();
		this.id = id;
		this.tenDanhMuc = tenDanhMuc;
		this.title = title;
		this.thuTuHienThi = thuTuHienThi;
		this.img = img;
		this.thoiGianTao = thoiGianTao;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public String getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}
	public void setThoiGianCapNhat(String thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", tenDanhMuc=" + tenDanhMuc + ", title=" + title + ", thuTuHienThi="
				+ thuTuHienThi + ", img=" + img + ", thoiGianTao=" + thoiGianTao + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}
	
}
