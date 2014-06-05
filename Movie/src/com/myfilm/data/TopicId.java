package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TopicId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TopicId implements java.io.Serializable {

	// Fields

	private Integer topicId;
	private Integer groupId;

	// Constructors

	/** default constructor */
	public TopicId() {
	}

	/** full constructor */
	public TopicId(Integer topicId, Integer groupId) {
		this.topicId = topicId;
		this.groupId = groupId;
	}

	// Property accessors

	@Column(name = "topic_id", nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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
		if (!(other instanceof TopicId))
			return false;
		TopicId castOther = (TopicId) other;

		return ((this.getTopicId() == castOther.getTopicId()) || (this
				.getTopicId() != null && castOther.getTopicId() != null && this
				.getTopicId().equals(castOther.getTopicId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this
						.getGroupId() != null && castOther.getGroupId() != null && this
						.getGroupId().equals(castOther.getGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTopicId() == null ? 0 : this.getTopicId().hashCode());
		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		return result;
	}

}