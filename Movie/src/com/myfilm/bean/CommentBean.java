package com.myfilm.bean;

public class CommentBean {
private String nickname;
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAddTime() {
	return addTime;
}
public void setAddTime(String addTime) {
	this.addTime = addTime;
}
public String getPhotolink() {
	return photolink;
}
public void setPhotolink(String photolink) {
	this.photolink = photolink;
}
private String content;
private String addTime;
private String photolink;
}
