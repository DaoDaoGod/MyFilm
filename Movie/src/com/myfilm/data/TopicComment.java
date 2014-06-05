package com.myfilm.data;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TopicComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topic_comment", catalog = "mydb")
public class TopicComment implements java.io.Serializable {

	// Fields

	private TopicCommentId id;
	private Topic topic;
	private Integer userId;
	private Timestamp addtime=new Timestamp(new Date().getDate());;
	private String content;

	// Constructors

	/** default constructor */
	public TopicComment() {
	}

	/** minimal constructor */
	public TopicComment(TopicCommentId id, Topic topic) {
		this.id = id;
		this.topic = topic;
	}

	/** full constructor */
	public TopicComment(TopicCommentId id, Topic topic, Integer userId,
			Timestamp addtime, String content) {
		this.id = id;
		this.topic = topic;
		this.userId = userId;
		this.addtime = addtime;
		this.content = content;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "tcommentId", column = @Column(name = "tcomment_id", nullable = false)),
			@AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)),
			@AttributeOverride(name = "topicId", column = @Column(name = "topic_id", nullable = false)) })
	public TopicCommentId getId() {
		return this.id;
	}

	public void setId(TopicCommentId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "topic_id", referencedColumnName = "topic_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false, insertable = false, updatable = false) })
	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "addtime", length = 19)
	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}