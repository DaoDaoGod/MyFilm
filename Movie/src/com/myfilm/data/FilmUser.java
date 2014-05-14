package com.myfilm.data;

/**
 * FilmUser entity. @author MyEclipse Persistence Tools
 */

public class FilmUser implements java.io.Serializable {

	// Fields

	private FilmUserId id;
	private Integer likestate;
	private Integer watchstate;

	// Constructors

	/** default constructor */
	public FilmUser() {
	}

	/** minimal constructor */
	public FilmUser(FilmUserId id) {
		this.id = id;
	}

	/** full constructor */
	public FilmUser(FilmUserId id, Integer likestate, Integer watchstate) {
		this.id = id;
		this.likestate = likestate;
		this.watchstate = watchstate;
	}

	// Property accessors

	public FilmUserId getId() {
		return this.id;
	}

	public void setId(FilmUserId id) {
		this.id = id;
	}

	public Integer getLikestate() {
		return this.likestate;
	}

	public void setLikestate(Integer likestate) {
		this.likestate = likestate;
	}

	public Integer getWatchstate() {
		return this.watchstate;
	}

	public void setWatchstate(Integer watchstate) {
		this.watchstate = watchstate;
	}

}