package com.user.model;

public class UserDTO {
	private int usernum;
	private String phone;
	private String pwd;
	private String name;
	private String nickname;
	private String email;
	private String time;
	private int seat;
	private int admin;
	
	public int getUserNum() {
		return usernum;
	}
	public void setUserNum(int userNum) {
		this.usernum = userNum;
	}
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname == null ? "" : nickname.trim();
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email == null ? "" : email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time == null ? "" : time.trim();
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
}
