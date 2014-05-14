package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Boxoffice entity. @author MyEclipse Persistence Tools
 */

public class Boxoffice implements java.io.Serializable {

	// Fields

	private BoxofficeId id;
	private String boxofficeName;
	private Set filmBoxoffices = new HashSet(0);

	// Constructors

	/** default constructor */
	public Boxoffice() {
	}

	/** minimal constructor */
	public Boxoffice(BoxofficeId id, String boxofficeName) {
		this.id = id;
		this.boxofficeName = boxofficeName;
	}

	/** full constructor */
	public Boxoffice(BoxofficeId id, String boxofficeName, Set filmBoxoffices) {
		this.id = id;
		this.boxofficeName = boxofficeName;
		this.filmBoxoffices = filmBoxoffices;
	}

	// Property accessors

	public BoxofficeId getId() {
		return this.id;
	}

	public void setId(BoxofficeId id) {
		this.id = id;
	}

	public String getBoxofficeName() {
		return this.boxofficeName;
	}

	public void setBoxofficeName(String boxofficeName) {
		this.boxofficeName = boxofficeName;
	}

	public Set getFilmBoxoffices() {
		return this.filmBoxoffices;
	}

	public void setFilmBoxoffices(Set filmBoxoffices) {
		this.filmBoxoffices = filmBoxoffices;
	}

}