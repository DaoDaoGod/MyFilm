package com.myfilm.bean;

import java.util.Date;

public class UserBean {
  
	public int getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	private int userId;
	private String email;
	private String nickname;
	private Boolean gender;
	private String birthday;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
}
