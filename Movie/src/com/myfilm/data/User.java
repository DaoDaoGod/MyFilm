package com.myfilm.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String email;
	private String password;
	private String nickname;
	private Boolean gender;
	private Date birthday;
	private Set groupComments = new HashSet(0);
	private Set userGroups = new HashSet(0);
	private Set filmUsers = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email) {
		this.email = email;
	}

	/** full constructor */
	public User(String email, String password, String nickname, Boolean gender,
			Date birthday, Set groupComments, Set userGroups, Set filmUsers,
			Set comments) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.groupComments = groupComments;
		this.userGroups = userGroups;
		this.filmUsers = filmUsers;
		this.comments = comments;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set groupComments) {
		this.groupComments = groupComments;
	}

	public Set getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set userGroups) {
		this.userGroups = userGroups;
	}

	public Set getFilmUsers() {
		return this.filmUsers;
	}

	public void setFilmUsers(Set filmUsers) {
		this.filmUsers = filmUsers;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}