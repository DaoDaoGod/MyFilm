package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmActorId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmActorId implements java.io.Serializable {

	// Fields

	private Integer actorId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public FilmActorId() {
	}

	/** full constructor */
	public FilmActorId(Integer actorId, Integer filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "actor_id", nullable = false)
	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmActorId))
			return false;
		FilmActorId castOther = (FilmActorId) other;

		return ((this.getActorId() == castOther.getActorId()) || (this
				.getActorId() != null && castOther.getActorId() != null && this
				.getActorId().equals(castOther.getActorId())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getActorId() == null ? 0 : this.getActorId().hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}