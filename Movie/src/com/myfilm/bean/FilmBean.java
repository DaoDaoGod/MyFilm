package com.myfilm.bean;

import java.util.Date;
import java.util.Set;

public class FilmBean {

	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FilmBean(int filmId,String name,String description)
	{
		this.filmId=filmId;
		this.name=name;
		this.description=description;
	}
	public FilmBean(){}
	private int filmId;
	private String name;
	private String description;
	
	
}
