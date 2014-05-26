package com.myfilm.bean;

import java.util.Date;
import java.util.Set;

import com.myfilm.data.Photo;

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
	public Set<Photo> getPhotoset() {
		return photoset;
	}
	public void setPhotoset(Set<Photo> photoset) {
		this.photoset = photoset;
	} 
	public FilmBean(){}
	public String getFilmupdate() {
		return filmupdate;
	}
	public void setFilmupdate(String filmupdate) {
		this.filmupdate = filmupdate;
	}
	public String getFilmlength() {
		return filmlength;
	}
	public void setFilmlength(String filmlength) {
		this.filmlength = filmlength;
	}
	public String getFilmothername() {
		return filmothername;
	}
	public void setFilmothername(String filmpthername) {
		this.filmothername = filmpthername;
	}
	public String getDblink() {
		return dblink;
	}
	public void setDblink(String dblink) {
		this.dblink = dblink;
	}
	public Set<String> getFilmactor() {
		return filmactor;
	}
	public void setFilmactor(Set<String> filmactor) {
		this.filmactor = filmactor;
	}
	public Set<String> getFilmtype() {
		return filmtype;
	}
	public void setFilmtype(Set<String> filmtype) {
		this.filmtype = filmtype;
	}
	public Set<String> getFilmplace() {
		return filmplace;
	}
	public void setFilmplace(Set<String> filmplace) {
		this.filmplace = filmplace;
	}
	public String getFilmdirector() {
		return filmdirector;
	}
	public void setFilmdirector(String filmdirector) {
		this.filmdirector = filmdirector;
	}
	private int filmId;
	private float dbgrade;
	public float getDbgrade() {
		return dbgrade;
	}
	public void setDbgrade(float dbgrade) {
		this.dbgrade = dbgrade;
	}
	private String name;
	private String description;
	private String filmdirector;
	private String filmupdate;
	private String filmlength;
	private String filmothername;
	private String dblink;
	private Set<String> filmactor;
	private Set<String> filmtype;
	private Set<String> filmplace;
	private Set<Photo> photoset;
	

}
