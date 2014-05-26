package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmPlace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_place", catalog = "mydb")
public class FilmPlace implements java.io.Serializable {

	// Fields

	private FilmPlaceId id;
	private Place place;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmPlace() {
	}

	/** full constructor */
	public FilmPlace(FilmPlaceId id, Place place, Film film) {
		this.id = id;
		this.place = place;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "placeId", column = @Column(name = "place_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public FilmPlaceId getId() {
		return this.id;
	}

	public void setId(FilmPlaceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "place_id", nullable = false, insertable = false, updatable = false)
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}