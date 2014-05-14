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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	private int userId;
	private String email;
	private String nickname;
	private Boolean gender;
	private Date birthday;
	public UserBean(int id,String email,String nickname,Boolean gender,Date birthday)
	{
		this.userId=id;
		this.email=email;
		this.nickname=nickname;
		this.gender=gender;
		this.birthday=birthday;
	}
}
