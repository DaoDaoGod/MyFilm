package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmBoxoffice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_boxoffice", catalog = "mydb")
public class FilmBoxoffice implements java.io.Serializable {

	// Fields

	private FilmBoxofficeId id;
	private Boxoffice boxoffice;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmBoxoffice() {
	}

	/** full constructor */
	public FilmBoxoffice(FilmBoxofficeId id, Boxoffice boxoffice, Film film) {
		this.id = id;
		this.boxoffice = boxoffice;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "boxofficeId", column = @Column(name = "boxoffice_id", nullable = false)),
			@AttributeOverride(name = "boxofficeWeeks", column = @Column(name = "boxoffice_weeks", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public FilmBoxofficeId getId() {
		return this.id;
	}

	public void setId(FilmBoxofficeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "boxoffice_id", referencedColumnName = "boxoffice_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "boxoffice_weeks", referencedColumnName = "weeks", nullable = false, insertable = false, updatable = false) })
	public Boxoffice getBoxoffice() {
		return this.boxoffice;
	}

	public void setBoxoffice(Boxoffice boxoffice) {
		this.boxoffice = boxoffice;
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