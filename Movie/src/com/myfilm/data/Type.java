package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String type;
	private Set filmTypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String type) {
		this.type = type;
	}

	/** full constructor */
	public Type(String type, Set filmTypes) {
		this.type = type;
		this.filmTypes = filmTypes;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getFilmTypes() {
		return this.filmTypes;
	}

	public void setFilmTypes(Set filmTypes) {
		this.filmTypes = filmTypes;
	}

}