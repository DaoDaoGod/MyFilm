package com.myfilm.data;

/**
 * FilmType entity. @author MyEclipse Persistence Tools
 */

public class FilmType implements java.io.Serializable {

	// Fields

	private FilmTypeId id;

	// Constructors

	/** default constructor */
	public FilmType() {
	}

	/** full constructor */
	public FilmType(FilmTypeId id) {
		this.id = id;
	}

	// Property accessors

	public FilmTypeId getId() {
		return this.id;
	}

	public void setId(FilmTypeId id) {
		this.id = id;
	}

}