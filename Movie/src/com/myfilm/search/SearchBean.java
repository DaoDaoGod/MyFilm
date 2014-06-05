package com.myfilm.search;
public class SearchBean {
	private String film_id;
	private String name;
	private String othername;
	private String director;
	private String actor;
	public String getId() {
		return film_id;
	}
	public void setId(String film_id) {
		this.film_id = film_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNickname() {
		return othername;
	}
	public void setNickname(String othername) {
		this.othername = othername;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getActorName() {
		return actor;
	}
	public void setActorName(String actor) {
		this.actor = actor;
	}
	
}
