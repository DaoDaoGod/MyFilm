package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Actor entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "actor", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "actor"))
public class Actor implements java.io.Serializable {

	// Fields

	private Integer actorId;
	private String actor;
	private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);

	// Constructors

	/** default constructor */
	public Actor() {
	}

	/** minimal constructor */
	public Actor(String actor) {
		this.actor = actor;
	}

	/** full constructor */
	public Actor(String actor, Set<FilmActor> filmActors) {
		this.actor = actor;
		this.filmActors = filmActors;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "actor_id", unique = true, nullable = false)
	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Column(name = "actor", unique = true, nullable = false, length = 45)
	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "actor")
	public Set<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

}