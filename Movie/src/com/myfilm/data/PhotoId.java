package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PhotoId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PhotoId implements java.io.Serializable {

	// Fields

	private Integer photoId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public PhotoId() {
	}

	/** full constructor */
	public PhotoId(Integer photoId, Integer filmId) {
		this.photoId = photoId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "photo_id", nullable = false)
	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
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
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPhotoId() == null ? 0 : this.getPhotoId().hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}