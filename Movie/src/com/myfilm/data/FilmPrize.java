package com.myfilm.data;

/**
 * FilmPrize entity. @author MyEclipse Persistence Tools
 */

public class FilmPrize implements java.io.Serializable {

	// Fields

	private FilmPrizeId id;

	// Constructors

	/** default constructor */
	public FilmPrize() {
	}

	/** full constructor */
	public FilmPrize(FilmPrizeId id) {
		this.id = id;
	}

	// Property accessors

	public FilmPrizeId getId() {
		return this.id;
	}

	public void setId(FilmPrizeId id) {
		this.id = id;
	}

}