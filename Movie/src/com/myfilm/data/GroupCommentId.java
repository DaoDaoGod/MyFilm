package com.myfilm.data;

/**
 * GroupCommentId entity. @author MyEclipse Persistence Tools
 */

public class GroupCommentId implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private User user;
	private Group group;

	// Constructors

	/** default constructor */
	public GroupCommentId() {
	}

	/** full constructor */
	public GroupCommentId(Integer commentId, User user, Group group) {
		this.commentId = commentId;
		this.user = user;
		this.group = group;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GroupCommentId))
			return false;
		GroupCommentId castOther = (GroupCommentId) other;

		return ((this.getCommentId() == castOther.getCommentId()) || (this
				.getCommentId() != null && castOther.getCommentId() != null && this
				.getCommentId().equals(castOther.getCommentId())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())))
				&& ((this.getGroup() == castOther.getGroup()) || (this
						.getGroup() != null && castOther.getGroup() != null && this
						.getGroup().equals(castOther.getGroup())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCommentId() == null ? 0 : this.getCommentId().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getGroup() == null ? 0 : this.getGroup().hashCode());
		return result;
	}

}