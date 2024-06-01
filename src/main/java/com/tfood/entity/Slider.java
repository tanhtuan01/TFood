package com.tfood.entity;

public class Slider {

	private int id;
	private String noiDung;
	private String img;
	private String date;
	private int stt;

	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Slider(int id, String noiDung, String img, String date) {
		super();
		this.id = id;
		this.noiDung = noiDung;
		this.img = img;
		this.date = date;
	}
	public Slider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
