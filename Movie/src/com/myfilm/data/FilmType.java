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
 * FilmType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_type", catalog = "mydb")
public class FilmType implements java.io.Serializable {

	// Fields

	private FilmTypeId id;
	private Type type;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmType() {
	}

	/** full constructor */
	public FilmType(FilmTypeId id, Type type, Film film) {
		this.id = id;
		this.type = type;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "typeId", column = @Column(name = "type_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public FilmTypeId getId() {
		return this.id;
	}

	public void setId(FilmTypeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id", nullable = false, insertable = false, updatable = false)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}