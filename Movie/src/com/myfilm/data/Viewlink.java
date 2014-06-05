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
import javax.persistence.UniqueConstraint;

/**
 * Viewlink entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "viewlink", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "viewlink"))
public class Viewlink implements java.io.Serializable {

	// Fields

	private ViewlinkId id;
	private Film film;
	private String viewlink;

	// Constructors

	/** default constructor */
	public Viewlink() {
	}

	/** full constructor */
	public Viewlink(ViewlinkId id, Film film, String viewlink) {
		this.id = id;
		this.film = film;
		this.viewlink = viewlink;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "viewlinkId", column = @Column(name = "viewlink_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public ViewlinkId getId() {
		return this.id;
	}

	public void setId(ViewlinkId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Column(name = "viewlink", unique = true, nullable = false)
	public String getViewlink() {
		return this.viewlink;
	}

	public void setViewlink(String viewlink) {
		this.viewlink = viewlink;
	}

}