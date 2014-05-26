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
 * FilmActor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_actor", catalog = "mydb")
public class FilmActor implements java.io.Serializable {

	// Fields

	private FilmActorId id;
	private Actor actor;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmActor() {
	}

	/** full constructor */
	public FilmActor(FilmActorId id, Actor actor, Film film) {
		this.id = id;
		this.actor = actor;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "actorId", column = @Column(name = "actor_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public FilmActorId getId() {
		return this.id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "actor_id", nullable = false, insertable = false, updatable = false)
	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
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