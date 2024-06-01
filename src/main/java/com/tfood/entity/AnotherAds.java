package com.tfood.entity;

public class AnotherAds {

	private int id;
	private String img;
	private String link;
	private String content;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public AnotherAds(int id, String img, String link, String content, String date) {
		super();
		this.id = id;
		this.img = img;
		this.link = link;
		this.content = content;
		this.date = date;
	}
	public AnotherAds() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
