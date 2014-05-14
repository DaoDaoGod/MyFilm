package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Place entity. @author MyEclipse Persistence Tools
 */

public class Place implements java.io.Serializable {

	// Fields

	private Integer placeId;
	private String place;
	private Set filmPlaces = new HashSet(0);

	// Constructors

	/** default constructor */
	public Place() {
	}

	/** minimal constructor */
	public Place(String place) {
		this.place = place;
	}

	/** full constructor */
	public Place(String place, Set filmPlaces) {
		this.place = place;
		this.filmPlaces = filmPlaces;
	}

	// Property accessors

	public Integer getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set getFilmPlaces() {
		return this.filmPlaces;
	}

	public void setFilmPlaces(Set filmPlaces) {
		this.filmPlaces = filmPlaces;
	}

}