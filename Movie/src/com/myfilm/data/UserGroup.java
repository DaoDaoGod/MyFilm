package com.myfilm.data;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */

public class UserGroup implements java.io.Serializable {

	// Fields

	private UserGroupId id;
	private Integer state;

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	/** minimal constructor */
	public UserGroup(UserGroupId id) {
		this.id = id;
	}

	/** full constructor */
	public UserGroup(UserGroupId id, Integer state) {
		this.id = id;
		this.state = state;
	}

	// Property accessors

	public UserGroupId getId() {
		return this.id;
	}

	public void setId(UserGroupId id) {
		this.id = id;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}