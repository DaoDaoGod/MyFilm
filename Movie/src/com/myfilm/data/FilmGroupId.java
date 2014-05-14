package com.myfilm.data;

/**
 * FilmGroupId entity. @author MyEclipse Persistence Tools
 */

public class FilmGroupId implements java.io.Serializable {

	// Fields

	private Film film;
	private Group group;

	// Constructors

	/** default constructor */
	public FilmGroupId() {
	}

	/** full constructor */
	public FilmGroupId(Film film, Group group) {
		this.film = film;
		this.group = group;
	}

	// Property accessors

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmGroupId))
			return false;
		FilmGroupId castOther = (FilmGroupId) other;

		return ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
				&& castOther.getFilm() != null && this.getFilm().equals(
				castOther.getFilm())))
				&& ((this.getGroup() == castOther.getGroup()) || (this
						.getGroup() != null && castOther.getGroup() != null && this
						.getGroup().equals(castOther.getGroup())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		result = 37 * result
				+ (getGroup() == null ? 0 : this.getGroup().hashCode());
		return result;
	}

}