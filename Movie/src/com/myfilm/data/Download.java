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
 * Download entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "download", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "dowload_link"))
public class Download implements java.io.Serializable {

	// Fields

	private DownloadId id;
	private Film film;
	private String dowloadLink;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** full constructor */
	public Download(DownloadId id, Film film, String dowloadLink) {
		this.id = id;
		this.film = film;
		this.dowloadLink = dowloadLink;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)),
			@AttributeOverride(name = "dowloadId", column = @Column(name = "dowload_id", nullable = false)) })
	public DownloadId getId() {
		return this.id;
	}

	public void setId(DownloadId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Column(name = "dowload_link", unique = true, nullable = false)
	public String getDowloadLink() {
		return this.dowloadLink;
	}

	public void setDowloadLink(String dowloadLink) {
		this.dowloadLink = dowloadLink;
	}

}