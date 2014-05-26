package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_group", catalog = "mydb")
public class UserGroup implements java.io.Serializable {

	// Fields

	private UserGroupId id;
	private User user;
	private Group group;
	private Integer state;

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	/** minimal constructor */
	public UserGroup(UserGroupId id, User user, Group group) {
		this.id = id;
		this.user = user;
		this.group = group;
	}

	/** full constructor */
	public UserGroup(UserGroupId id, User user, Group group, Integer state) {
		this.id = id;
		this.user = user;
		this.group = group;
		this.state = state;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public UserGroupId getId() {
		return this.id;
	}

	public void setId(UserGroupId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}