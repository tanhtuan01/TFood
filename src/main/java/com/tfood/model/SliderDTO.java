package com.tfood.model;

public class SliderDTO {
	
	private int id;
	private String noiDung;
	private String img;
	private String date;
	private int stt;
	private int status = 0;
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
	public SliderDTO(int id, String noiDung, String img, String date) {
		super();
		this.id = id;
		this.noiDung = noiDung;
		this.img = img;
		this.date = date;
	}
	public SliderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String setClass() {
		if(this.stt == 1 && this.status == 0) {
			status = this.stt;
			return "carousel-item active";
		}else {
			return "carousel-item";
		}
	}
}
