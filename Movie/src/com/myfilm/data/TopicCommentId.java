package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TopicCommentId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TopicCommentId implements java.io.Serializable {

	// Fields

	private Integer tcommentId;
	private Integer groupId;
	private Integer topicId;

	// Constructors

	/** default constructor */
	public TopicCommentId() {
	}

	/** full constructor */
	public TopicCommentId(Integer tcommentId, Integer groupId, Integer topicId) {
		this.tcommentId = tcommentId;
		this.groupId = groupId;
		this.topicId = topicId;
	}

	// Property accessors

	@Column(name = "tcomment_id", nullable = false)
	public Integer getTcommentId() {
		return this.tcommentId;
	}

	public void setTcommentId(Integer tcommentId) {
		this.tcommentId = tcommentId;
	}

	@Column(name = "group_id", nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "topic_id", nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TopicCommentId))
			return false;
		TopicCommentId castOther = (TopicCommentId) other;

		return ((this.getTcommentId() == castOther.getTcommentId()) || (this
				.getTcommentId() != null && castOther.getTcommentId() != null && this
				.getTcommentId().equals(castOther.getTcommentId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this
						.getGroupId() != null && castOther.getGroupId() != null && this
						.getGroupId().equals(castOther.getGroupId())))
				&& ((this.getTopicId() == castOther.getTopicId()) || (this
						.getTopicId() != null && castOther.getTopicId() != null && this
						.getTopicId().equals(castOther.getTopicId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTcommentId() == null ? 0 : this.getTcommentId()
						.hashCode());
		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		result = 37 * result
				+ (getTopicId() == null ? 0 : this.getTopicId().hashCode());
		return result;
	}

}