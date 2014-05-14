package com.myfilm.data;

/**
 * FilmActor entity. @author MyEclipse Persistence Tools
 */

public class FilmActor implements java.io.Serializable {

	// Fields

	private FilmActorId id;

	// Constructors

	/** default constructor */
	public FilmActor() {
	}

	/** full constructor */
	public FilmActor(FilmActorId id) {
		this.id = id;
	}

	// Property accessors

	public FilmActorId getId() {
		return this.id;
	}

	public void setId(FilmActorId id) {
		this.id = id;
	}

}