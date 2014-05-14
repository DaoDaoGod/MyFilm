package com.myfilm.data;

/**
 * UserGroupId entity. @author MyEclipse Persistence Tools
 */

public class UserGroupId implements java.io.Serializable {

	// Fields

	private Group group;
	private User user;

	// Constructors

	/** default constructor */
	public UserGroupId() {
	}

	/** full constructor */
	public UserGroupId(Group group, User user) {
		this.group = group;
		this.user = user;
	}

	// Property accessors

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserGroupId))
			return false;
		UserGroupId castOther = (UserGroupId) other;

		return ((this.getGroup() == castOther.getGroup()) || (this.getGroup() != null
				&& castOther.getGroup() != null && this.getGroup().equals(
				castOther.getGroup())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroup() == null ? 0 : this.getGroup().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		return result;
	}

}