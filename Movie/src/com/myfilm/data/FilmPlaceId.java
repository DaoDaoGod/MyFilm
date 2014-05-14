package com.myfilm.data;

/**
 * FilmPlaceId entity. @author MyEclipse Persistence Tools
 */

public class FilmPlaceId implements java.io.Serializable {

	// Fields

	private Place place;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmPlaceId() {
	}

	/** full constructor */
	public FilmPlaceId(Place place, Film film) {
		this.place = place;
		this.film = film;
	}

	// Property accessors

	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
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
		if (!(other instanceof FilmPlaceId))
			return false;
		FilmPlaceId castOther = (FilmPlaceId) other;

		return ((this.getPlace() == castOther.getPlace()) || (this.getPlace() != null
				&& castOther.getPlace() != null && this.getPlace().equals(
				castOther.getPlace())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPlace() == null ? 0 : this.getPlace().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}