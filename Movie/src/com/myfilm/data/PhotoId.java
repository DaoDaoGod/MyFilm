package com.myfilm.data;

/**
 * PhotoId entity. @author MyEclipse Persistence Tools
 */

public class PhotoId implements java.io.Serializable {

	// Fields

	private Integer photoId;
	private Film film;

	// Constructors

	/** default constructor */
	public PhotoId() {
	}

	/** full constructor */
	public PhotoId(Integer photoId, Film film) {
		this.photoId = photoId;
		this.film = film;
	}

	// Property accessors

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PhotoId))
			return false;
		PhotoId castOther = (PhotoId) other;

		return ((this.getPhotoId() == castOther.getPhotoId()) || (this
				.getPhotoId() != null && castOther.getPhotoId() != null && this
				.getPhotoId().equals(castOther.getPhotoId())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPhotoId() == null ? 0 : this.getPhotoId().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		return result;
	}

}