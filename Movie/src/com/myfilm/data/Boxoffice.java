package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Boxoffice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "boxoffice", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "boxoffice_name"))
public class Boxoffice implements java.io.Serializable {

	// Fields

	private BoxofficeId id;
	private String boxofficeName;
	private Set<FilmBoxoffice> filmBoxoffices = new HashSet<FilmBoxoffice>(0);

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
	public Boxoffice(BoxofficeId id, String boxofficeName,
			Set<FilmBoxoffice> filmBoxoffices) {
		this.id = id;
		this.boxofficeName = boxofficeName;
		this.filmBoxoffices = filmBoxoffices;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "boxofficeId", column = @Column(name = "boxoffice_id", nullable = false)),
			@AttributeOverride(name = "weeks", column = @Column(name = "weeks", nullable = false)) })
	public BoxofficeId getId() {
		return this.id;
	}

	public void setId(BoxofficeId id) {
		this.id = id;
	}

	@Column(name = "boxoffice_name", unique = true, nullable = false, length = 45)
	public String getBoxofficeName() {
		return this.boxofficeName;
	}

	public void setBoxofficeName(String boxofficeName) {
		this.boxofficeName = boxofficeName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "boxoffice")
	public Set<FilmBoxoffice> getFilmBoxoffices() {
		return this.filmBoxoffices;
	}

	public void setFilmBoxoffices(Set<FilmBoxoffice> filmBoxoffices) {
		this.filmBoxoffices = filmBoxoffices;
	}

}