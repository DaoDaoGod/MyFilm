package com.myfilm.data;

/**
 * FilmBoxofficeId entity. @author MyEclipse Persistence Tools
 */

public class FilmBoxofficeId implements java.io.Serializable {

	// Fields

	private Boxoffice boxoffice;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmBoxofficeId() {
	}

	/** full constructor */
	public FilmBoxofficeId(Boxoffice boxoffice, Film film) {
		this.boxoffice = boxoffice;
		this.film = film;
	}

	// Property accessors

	public Boxoffice getBoxoffice() {
		return this.boxoffice;
	}

	public void setBoxoffice(Boxoffice boxoffice) {
		this.boxoffice = boxoffice;
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
		if (!(other instanceof FilmBoxofficeId))
			return false;
		FilmBoxofficeId castOther = (FilmBoxofficeId) other;

		return ((this.getBoxoffice() == castOther.getBoxoffice()) || (this
				.getBoxoffice() != null && castOther.getBoxoffice() != null && this
				.getBoxoffice().equals(castOther.getBoxoffice())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBoxoffice() == null ? 0 : this.getBoxoffice().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}