package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmPlaceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmPlaceId implements java.io.Serializable {

	// Fields

	private Integer placeId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public FilmPlaceId() {
	}

	/** full constructor */
	public FilmPlaceId(Integer placeId, Integer filmId) {
		this.placeId = placeId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "place_id", nullable = false)
	public Integer getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
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
		if (!(other instanceof FilmPlaceId))
			return false;
		FilmPlaceId castOther = (FilmPlaceId) other;

		return ((this.getPlaceId() == castOther.getPlaceId()) || (this
				.getPlaceId() != null && castOther.getPlaceId() != null && this
				.getPlaceId().equals(castOther.getPlaceId())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPlaceId() == null ? 0 : this.getPlaceId().hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}