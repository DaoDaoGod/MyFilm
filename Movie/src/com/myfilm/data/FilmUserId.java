package com.myfilm.data;

/**
 * FilmUserId entity. @author MyEclipse Persistence Tools
 */

public class FilmUserId implements java.io.Serializable {

	// Fields

	private Film film;
	private User user;

	// Constructors

	/** default constructor */
	public FilmUserId() {
	}

	/** full constructor */
	public FilmUserId(Film film, User user) {
		this.film = film;
		this.user = user;
	}

	// Property accessors

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmUserId))
			return false;
		FilmUserId castOther = (FilmUserId) other;

		return ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
				&& castOther.getFilm() != null && this.getFilm().equals(
				castOther.getFilm())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		return result;
	}

}