package com.myfilm.bean;

import java.util.List;

import com.myfilm.data.Topic;

public class GroupBean {
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public String getGroupOwner() {
		return groupOwner;
	}
	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}
	public Integer getDroupNumber() {
		return droupNumber;
	}
	public void setDroupNumber(Integer droupNumber) {
		this.droupNumber = droupNumber;
	}
	private Integer groupId;
	private String  groupName;
	private String  groupDescription;
	private String  groupOwner;
	private Integer droupNumber;
	private List<Topic> grouptopics;
	private List<TopicBean> topics;
	public List<TopicBean> getTopics() {
		return topics;
	}
	public void setTopics(List<TopicBean> topics) {
		this.topics = topics;
	}
	public List<Topic> getGrouptopics() {
		return grouptopics;
	}
	public void setGrouptopics(List<Topic> grouptopics) {
		this.grouptopics = grouptopics;
	}
}
