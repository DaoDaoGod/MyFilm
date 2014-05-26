package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmUserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmUserId implements java.io.Serializable {

	// Fields

	private Integer filmId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public FilmUserId() {
	}

	/** full constructor */
	public FilmUserId(Integer filmId, Integer userId) {
		this.filmId = filmId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmUserId))
			return false;
		FilmUserId castOther = (FilmUserId) other;

		return ((this.getFilmId() == castOther.getFilmId()) || (this
				.getFilmId() != null && castOther.getFilmId() != null && this
				.getFilmId().equals(castOther.getFilmId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}