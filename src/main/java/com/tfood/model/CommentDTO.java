package com.tfood.model;

public class CommentDTO {

	private int id;
	private int user;
	private int food;
	private int score;
	private String content;
	private String date;
	private String name;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	public CommentDTO(int id, int user, int food, int score, String content, String date) {
		super();
		this.id = id;
		this.user = user;
		this.food = food;
		this.score = score;
		this.content = content;
		this.date = date;
	}
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
