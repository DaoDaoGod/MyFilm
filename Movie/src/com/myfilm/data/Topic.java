package com.myfilm.data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topic", catalog = "mydb")
public class Topic implements java.io.Serializable {

	// Fields

	private TopicId id;
	private Group group;
	private Integer userId;
	private String username;
	private String name;
	private Timestamp addtime=new Timestamp(new Date().getDay());
	private String content;
	private Set<TopicComment> topicComments = new HashSet<TopicComment>(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(TopicId id, Group group) {
		this.id = id;
		this.group = group;
	}

	/** full constructor */
	public Topic(TopicId id, Group group, Integer userId, String username,
			String name, Timestamp addtime, String content,
			Set<TopicComment> topicComments) {
		this.id = id;
		this.group = group;
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.addtime = addtime;
		this.content = content;
		this.topicComments = topicComments;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "topicId", column = @Column(name = "topic_id", nullable = false)),
			@AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)) })
	public TopicId getId() {
		return this.id;
	}

	public void setId(TopicId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "topic")
	public Set<TopicComment> getTopicComments() {
		return this.topicComments;
	}

	public void setTopicComments(Set<TopicComment> topicComments) {
		this.topicComments = topicComments;
	}

}