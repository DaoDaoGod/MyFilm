package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DownloadId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DownloadId implements java.io.Serializable {

	// Fields

	private Integer filmId;
	private Integer dowloadId;

	// Constructors

	/** default constructor */
	public DownloadId() {
	}

	/** full constructor */
	public DownloadId(Integer filmId, Integer dowloadId) {
		this.filmId = filmId;
		this.dowloadId = dowloadId;
	}

	// Property accessors

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Column(name = "dowload_id", nullable = false)
	public Integer getDowloadId() {
		return this.dowloadId;
	}

	public void setDowloadId(Integer dowloadId) {
		this.dowloadId = dowloadId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DownloadId))
			return false;
		DownloadId castOther = (DownloadId) other;

		return ((this.getFilmId() == castOther.getFilmId()) || (this
				.getFilmId() != null && castOther.getFilmId() != null && this
				.getFilmId().equals(castOther.getFilmId())))
				&& ((this.getDowloadId() == castOther.getDowloadId()) || (this
						.getDowloadId() != null
						&& castOther.getDowloadId() != null && this
						.getDowloadId().equals(castOther.getDowloadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		result = 37 * result
				+ (getDowloadId() == null ? 0 : this.getDowloadId().hashCode());
		return result;
	}

}