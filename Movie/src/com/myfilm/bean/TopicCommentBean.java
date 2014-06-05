package com.myfilm.bean;

import java.sql.Timestamp;

import com.myfilm.data.Topic;
import com.myfilm.data.TopicCommentId;

public class TopicCommentBean {

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private Integer TopicCommentid;
	private Integer userId;
	private String addtime;
	private String content;
	public Integer getTopicCommentid() {
		return TopicCommentid;
	}
	public void setTopicCommentid(Integer topicCommentid) {
		TopicCommentid = topicCommentid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
}
