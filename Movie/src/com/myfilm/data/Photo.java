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
 * Photo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "photolink"))
public class Photo implements java.io.Serializable {

	// Fields

	private PhotoId id;
	private Film film;
	private String photolink;
	private Boolean ismainphoto;
	private String photocol;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** minimal constructor */
	public Photo(PhotoId id, Film film, String photolink) {
		this.id = id;
		this.film = film;
		this.photolink = photolink;
	}

	/** full constructor */
	public Photo(PhotoId id, Film film, String photolink, Boolean ismainphoto,
			String photocol) {
		this.id = id;
		this.film = film;
		this.photolink = photolink;
		this.ismainphoto = ismainphoto;
		this.photocol = photocol;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "photoId", column = @Column(name = "photo_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)) })
	public PhotoId getId() {
		return this.id;
	}

	public void setId(PhotoId id) {
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

	@Column(name = "photolink", unique = true, nullable = false)
	public String getPhotolink() {
		return this.photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	@Column(name = "ismainphoto")
	public Boolean getIsmainphoto() {
		return this.ismainphoto;
	}

	public void setIsmainphoto(Boolean ismainphoto) {
		this.ismainphoto = ismainphoto;
	}

	@Column(name = "photocol", length = 45)
	public String getPhotocol() {
		return this.photocol;
	}

	public void setPhotocol(String photocol) {
		this.photocol = photocol;
	}

}