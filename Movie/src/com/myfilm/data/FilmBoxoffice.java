package com.myfilm.data;

/**
 * FilmBoxoffice entity. @author MyEclipse Persistence Tools
 */

public class FilmBoxoffice implements java.io.Serializable {

	// Fields

	private FilmBoxofficeId id;

	// Constructors

	/** default constructor */
	public FilmBoxoffice() {
	}

	/** full constructor */
	public FilmBoxoffice(FilmBoxofficeId id) {
		this.id = id;
	}

	// Property accessors

	public FilmBoxofficeId getId() {
		return this.id;
	}

	public void setId(FilmBoxofficeId id) {
		this.id = id;
	}

}