package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_group", catalog = "mydb")
public class FilmGroup implements java.io.Serializable {

	// Fields

	private FilmGroupId id;
	private Group group;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmGroup() {
	}

	/** full constructor */
	public FilmGroup(FilmGroupId id, Group group, Film film) {
		this.id = id;
		this.group = group;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)),
			@AttributeOverride(name = "groupId", column = @Column(name = "group_id", nullable = false)) })
	public FilmGroupId getId() {
		return this.id;
	}

	public void setId(FilmGroupId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}