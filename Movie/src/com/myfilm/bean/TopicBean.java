package com.myfilm.bean;

import java.sql.Timestamp;
import java.util.List;

public class TopicBean {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	private List<TopicCommentBean> topComments;
	public List<TopicCommentBean> getTopComments() {
		return topComments;
	}
	public void setTopComments(List<TopicCommentBean> topComments) {
		this.topComments = topComments;
	}
	private String name;
	private String username;
	private String addtime;
	private String content;
	private Integer topicId;
	private Integer groupId;

}
