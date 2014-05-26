package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GroupCommentId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class GroupCommentId implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer userId;
	private Integer groupId;

	// Constructors

	/** default constructor */
	public GroupCommentId() {
	}

	/** full constructor */
	public GroupCommentId(Integer commentId, Integer userId, Integer groupId) {
		this.commentId = commentId;
		this.userId = userId;
		this.groupId = groupId;
	}

	// Property accessors

	@Column(name = "comment_id", nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "group_id", nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this
						.getGroupId() != null && castOther.getGroupId() != null && this
						.getGroupId().equals(castOther.getGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCommentId() == null ? 0 : this.getCommentId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		return result;
	}

}