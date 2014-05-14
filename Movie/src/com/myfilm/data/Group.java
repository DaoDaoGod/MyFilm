package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private String groupName;
	private String groupDescription;
	private String groupOwner;
	private Set userGroups = new HashSet(0);
	private Set groupComments = new HashSet(0);
	private Set filmGroups = new HashSet(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(String groupName) {
		this.groupName = groupName;
	}

	/** full constructor */
	public Group(String groupName, String groupDescription, String groupOwner,
			Set userGroups, Set groupComments, Set filmGroups) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.groupOwner = groupOwner;
		this.userGroups = userGroups;
		this.groupComments = groupComments;
		this.filmGroups = filmGroups;
	}

	// Property accessors

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getGroupOwner() {
		return this.groupOwner;
	}

	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}

	public Set getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set userGroups) {
		this.userGroups = userGroups;
	}

	public Set getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set groupComments) {
		this.groupComments = groupComments;
	}

	public Set getFilmGroups() {
		return this.filmGroups;
	}

	public void setFilmGroups(Set filmGroups) {
		this.filmGroups = filmGroups;
	}

}