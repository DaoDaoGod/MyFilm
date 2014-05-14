package com.myfilm.data;

/**
 * FilmPlace entity. @author MyEclipse Persistence Tools
 */

public class FilmPlace implements java.io.Serializable {

	// Fields

	private FilmPlaceId id;

	// Constructors

	/** default constructor */
	public FilmPlace() {
	}

	/** full constructor */
	public FilmPlace(FilmPlaceId id) {
		this.id = id;
	}

	// Property accessors

	public FilmPlaceId getId() {
		return this.id;
	}

	public void setId(FilmPlaceId id) {
		this.id = id;
	}

}