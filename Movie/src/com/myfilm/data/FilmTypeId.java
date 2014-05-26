package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmTypeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmTypeId implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public FilmTypeId() {
	}

	/** full constructor */
	public FilmTypeId(Integer typeId, Integer filmId) {
		this.typeId = typeId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "type_id", nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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
		if (!(other instanceof FilmTypeId))
			return false;
		FilmTypeId castOther = (FilmTypeId) other;

		return ((this.getTypeId() == castOther.getTypeId()) || (this
				.getTypeId() != null && castOther.getTypeId() != null && this
				.getTypeId().equals(castOther.getTypeId())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTypeId() == null ? 0 : this.getTypeId().hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}