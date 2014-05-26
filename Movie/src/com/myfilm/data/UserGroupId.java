package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserGroupId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UserGroupId implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public UserGroupId() {
	}

	/** full constructor */
	public UserGroupId(Integer groupId, Integer userId) {
		this.groupId = groupId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "group_id", nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserGroupId))
			return false;
		UserGroupId castOther = (UserGroupId) other;

		return ((this.getGroupId() == castOther.getGroupId()) || (this
				.getGroupId() != null && castOther.getGroupId() != null && this
				.getGroupId().equals(castOther.getGroupId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}