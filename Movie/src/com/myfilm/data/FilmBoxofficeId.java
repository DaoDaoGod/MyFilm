package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmBoxofficeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmBoxofficeId implements java.io.Serializable {

	// Fields

	private Integer boxofficeId;
	private Integer boxofficeWeeks;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public FilmBoxofficeId() {
	}

	/** full constructor */
	public FilmBoxofficeId(Integer boxofficeId, Integer boxofficeWeeks,
			Integer filmId) {
		this.boxofficeId = boxofficeId;
		this.boxofficeWeeks = boxofficeWeeks;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "boxoffice_id", nullable = false)
	public Integer getBoxofficeId() {
		return this.boxofficeId;
	}

	public void setBoxofficeId(Integer boxofficeId) {
		this.boxofficeId = boxofficeId;
	}

	@Column(name = "boxoffice_weeks", nullable = false)
	public Integer getBoxofficeWeeks() {
		return this.boxofficeWeeks;
	}

	public void setBoxofficeWeeks(Integer boxofficeWeeks) {
		this.boxofficeWeeks = boxofficeWeeks;
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
		if (!(other instanceof FilmBoxofficeId))
			return false;
		FilmBoxofficeId castOther = (FilmBoxofficeId) other;

		return ((this.getBoxofficeId() == castOther.getBoxofficeId()) || (this
				.getBoxofficeId() != null && castOther.getBoxofficeId() != null && this
				.getBoxofficeId().equals(castOther.getBoxofficeId())))
				&& ((this.getBoxofficeWeeks() == castOther.getBoxofficeWeeks()) || (this
						.getBoxofficeWeeks() != null
						&& castOther.getBoxofficeWeeks() != null && this
						.getBoxofficeWeeks().equals(
								castOther.getBoxofficeWeeks())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getBoxofficeId() == null ? 0 : this.getBoxofficeId()
						.hashCode());
		result = 37
				* result
				+ (getBoxofficeWeeks() == null ? 0 : this.getBoxofficeWeeks()
						.hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}