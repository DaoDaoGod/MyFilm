package com.myfilm.data;

/**
 * GroupComment entity. @author MyEclipse Persistence Tools
 */

public class GroupComment implements java.io.Serializable {

	// Fields

	private GroupCommentId id;
	private String email;
	private String username;
	private String content;
	private String addTime;

	// Constructors

	/** default constructor */
	public GroupComment() {
	}

	/** minimal constructor */
	public GroupComment(GroupCommentId id, String email) {
		this.id = id;
		this.email = email;
	}

	/** full constructor */
	public GroupComment(GroupCommentId id, String email, String username,
			String content, String addTime) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.content = content;
		this.addTime = addTime;
	}

	// Property accessors

	public GroupCommentId getId() {
		return this.id;
	}

	public void setId(GroupCommentId id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddTime() {
		return this.addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}