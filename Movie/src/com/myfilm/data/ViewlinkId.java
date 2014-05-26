package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ViewlinkId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ViewlinkId implements java.io.Serializable {

	// Fields

	private Integer viewlinkId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public ViewlinkId() {
	}

	/** full constructor */
	public ViewlinkId(Integer viewlinkId, Integer filmId) {
		this.viewlinkId = viewlinkId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "viewlink_id", nullable = false)
	public Integer getViewlinkId() {
		return this.viewlinkId;
	}

	public void setViewlinkId(Integer viewlinkId) {
		this.viewlinkId = viewlinkId;
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
		if (!(other instanceof ViewlinkId))
			return false;
		ViewlinkId castOther = (ViewlinkId) other;

		return ((this.getViewlinkId() == castOther.getViewlinkId()) || (this
				.getViewlinkId() != null && castOther.getViewlinkId() != null && this
				.getViewlinkId().equals(castOther.getViewlinkId())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getViewlinkId() == null ? 0 : this.getViewlinkId()
						.hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}