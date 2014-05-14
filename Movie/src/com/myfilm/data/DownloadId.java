package com.myfilm.data;

/**
 * DownloadId entity. @author MyEclipse Persistence Tools
 */

public class DownloadId implements java.io.Serializable {

	// Fields

	private Film film;
	private Integer dowloadId;

	// Constructors

	/** default constructor */
	public DownloadId() {
	}

	/** full constructor */
	public DownloadId(Film film, Integer dowloadId) {
		this.film = film;
		this.dowloadId = dowloadId;
	}

	// Property accessors

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

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

		return ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
				&& castOther.getFilm() != null && this.getFilm().equals(
				castOther.getFilm())))
				&& ((this.getDowloadId() == castOther.getDowloadId()) || (this
						.getDowloadId() != null
						&& castOther.getDowloadId() != null && this
						.getDowloadId().equals(castOther.getDowloadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		result = 37 * result
				+ (getDowloadId() == null ? 0 : this.getDowloadId().hashCode());
		return result;
	}

}