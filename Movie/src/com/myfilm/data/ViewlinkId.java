package com.myfilm.data;

/**
 * ViewlinkId entity. @author MyEclipse Persistence Tools
 */

public class ViewlinkId implements java.io.Serializable {

	// Fields

	private Integer viewlinkId;
	private Film film;

	// Constructors

	/** default constructor */
	public ViewlinkId() {
	}

	/** full constructor */
	public ViewlinkId(Integer viewlinkId, Film film) {
		this.viewlinkId = viewlinkId;
		this.film = film;
	}

	// Property accessors

	public Integer getViewlinkId() {
		return this.viewlinkId;
	}

	public void setViewlinkId(Integer viewlinkId) {
		this.viewlinkId = viewlinkId;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
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
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getViewlinkId() == null ? 0 : this.getViewlinkId()
						.hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}