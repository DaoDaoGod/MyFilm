package com.myfilm.data;

/**
 * FilmActorId entity. @author MyEclipse Persistence Tools
 */

public class FilmActorId implements java.io.Serializable {

	// Fields

	private Actor actor;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmActorId() {
	}

	/** full constructor */
	public FilmActorId(Actor actor, Film film) {
		this.actor = actor;
		this.film = film;
	}

	// Property accessors

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
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
		if (!(other instanceof FilmActorId))
			return false;
		FilmActorId castOther = (FilmActorId) other;

		return ((this.getActor() == castOther.getActor()) || (this.getActor() != null
				&& castOther.getActor() != null && this.getActor().equals(
				castOther.getActor())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getActor() == null ? 0 : this.getActor().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}