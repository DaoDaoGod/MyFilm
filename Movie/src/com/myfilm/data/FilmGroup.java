package com.myfilm.data;

/**
 * FilmGroup entity. @author MyEclipse Persistence Tools
 */

public class FilmGroup implements java.io.Serializable {

	// Fields

	private FilmGroupId id;

	// Constructors

	/** default constructor */
	public FilmGroup() {
	}

	/** full constructor */
	public FilmGroup(FilmGroupId id) {
		this.id = id;
	}

	// Property accessors

	public FilmGroupId getId() {
		return this.id;
	}

	public void setId(FilmGroupId id) {
		this.id = id;
	}

}