package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmGroupId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmGroupId implements java.io.Serializable {

	// Fields

	private Integer filmId;
	private Integer groupId;

	// Constructors

	/** default constructor */
	public FilmGroupId() {
	}

	/** full constructor */
	public FilmGroupId(Integer filmId, Integer groupId) {
		this.filmId = filmId;
		this.groupId = groupId;
	}

	// Property accessors

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Column(name = "group_id", nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmGroupId))
			return false;
		FilmGroupId castOther = (FilmGroupId) other;

		return ((this.getFilmId() == castOther.getFilmId()) || (this
				.getFilmId() != null && castOther.getFilmId() != null && this
				.getFilmId().equals(castOther.getFilmId())))
				&& ((this.getGroupId() == castOther.getGroupId()) || (this
						.getGroupId() != null && castOther.getGroupId() != null && this
						.getGroupId().equals(castOther.getGroupId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		result = 37 * result
				+ (getGroupId() == null ? 0 : this.getGroupId().hashCode());
		return result;
	}

}