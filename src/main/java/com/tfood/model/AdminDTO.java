package com.tfood.model;

public class AdminDTO {

	private int id;
	private String username;
	private String password;
	private String thoiGianTao;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getThoiGianTao() {
		return thoiGianTao;
	}
	public void setThoiGianTao(String thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}
	public AdminDTO(int id, String username, String password, String thoiGianTao) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.thoiGianTao = thoiGianTao;
	}
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", username=" + username + ", password=" + password + ", thoiGianTao=" + thoiGianTao
				+ "]";
	}

	
}
