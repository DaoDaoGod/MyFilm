package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_user", catalog = "mydb")
public class FilmUser implements java.io.Serializable {

	// Fields

	private FilmUserId id;
	private User user;
	private Film film;
	private Integer likestate;
	private Integer watchstate;

	// Constructors

	/** default constructor */
	public FilmUser() {
	}

	/** minimal constructor */
	public FilmUser(FilmUserId id, User user, Film film) {
		this.id = id;
		this.user = user;
		this.film = film;
	}

	/** full constructor */
	public FilmUser(FilmUserId id, User user, Film film, Integer likestate,
			Integer watchstate) {
		this.id = id;
		this.user = user;
		this.film = film;
		this.likestate = likestate;
		this.watchstate = watchstate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false)) })
	public FilmUserId getId() {
		return this.id;
	}

	public void setId(FilmUserId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Column(name = "likestate")
	public Integer getLikestate() {
		return this.likestate;
	}

	public void setLikestate(Integer likestate) {
		this.likestate = likestate;
	}

	@Column(name = "watchstate")
	public Integer getWatchstate() {
		return this.watchstate;
	}

	public void setWatchstate(Integer watchstate) {
		this.watchstate = watchstate;
	}

}