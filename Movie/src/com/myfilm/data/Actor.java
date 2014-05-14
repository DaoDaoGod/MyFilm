package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Actor entity. @author MyEclipse Persistence Tools
 */

public class Actor implements java.io.Serializable {

	// Fields

	private Integer actorId;
	private String actor;
	private Set filmActors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Actor() {
	}

	/** minimal constructor */
	public Actor(String actor) {
		this.actor = actor;
	}

	/** full constructor */
	public Actor(String actor, Set filmActors) {
		this.actor = actor;
		this.filmActors = filmActors;
	}

	// Property accessors

	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public Set getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set filmActors) {
		this.filmActors = filmActors;
	}

}