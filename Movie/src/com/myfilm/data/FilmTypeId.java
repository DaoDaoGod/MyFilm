package com.myfilm.data;

/**
 * FilmTypeId entity. @author MyEclipse Persistence Tools
 */

public class FilmTypeId implements java.io.Serializable {

	// Fields

	private Type type;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmTypeId() {
	}

	/** full constructor */
	public FilmTypeId(Type type, Film film) {
		this.type = type;
		this.film = film;
	}

	// Property accessors

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
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
		if (!(other instanceof FilmTypeId))
			return false;
		FilmTypeId castOther = (FilmTypeId) other;

		return ((this.getType() == castOther.getType()) || (this.getType() != null
				&& castOther.getType() != null && this.getType().equals(
				castOther.getType())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}