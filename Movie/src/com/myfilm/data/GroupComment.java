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
import javax.persistence.UniqueConstraint;

/**
 * GroupComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group_comment", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class GroupComment implements java.io.Serializable {

	// Fields

	private GroupCommentId id;
	private User user;
	private Group group;
	private String email;
	private String username;
	private String content;
	private String addTime;

	// Constructors

	/** default constructor */
	public GroupComment() {
	}

	/** minimal constructor */
	public GroupComment(GroupCommentId id, User user, Group group, String email) {
		this.id = id;
		this.user = user;
		this.group = group;
		this.email = email;
	}

	/** full constructor */
	public GroupComment(GroupCommentId id, User user, Group group,
			String email, String username, String content, String addTime) {
		this.id = id;
		this.user = user;
		this.group = group;
		this.email = email;
		this.username = username;
		this.content = content;
		this.addTime = addTime;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "commentId", column = @Column(name = "comment_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)),
			@AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)) })
	public GroupCommentId getId() {
		return this.id;
	}

	public void setId(GroupCommentId id) {
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

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "add_time", length = 45)
	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}