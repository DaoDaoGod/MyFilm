package com.myfilm.data;

/**
 * FilmPrizeId entity. @author MyEclipse Persistence Tools
 */

public class FilmPrizeId implements java.io.Serializable {

	// Fields

	private Integer prizeId;
	private Film film;
	private Integer prizeYear;

	// Constructors

	/** default constructor */
	public FilmPrizeId() {
	}

	/** full constructor */
	public FilmPrizeId(Integer prizeId, Film film, Integer prizeYear) {
		this.prizeId = prizeId;
		this.film = film;
		this.prizeYear = prizeYear;
	}

	// Property accessors

	public Integer getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Integer getPrizeYear() {
		return this.prizeYear;
	}

	public void setPrizeYear(Integer prizeYear) {
		this.prizeYear = prizeYear;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FilmPrizeId))
			return false;
		FilmPrizeId castOther = (FilmPrizeId) other;

		return ((this.getPrizeId() == castOther.getPrizeId()) || (this
				.getPrizeId() != null && castOther.getPrizeId() != null && this
				.getPrizeId().equals(castOther.getPrizeId())))
				&& ((this.getFilm() == castOther.getFilm()) || (this.getFilm() != null
						&& castOther.getFilm() != null && this.getFilm()
						.equals(castOther.getFilm())))
				&& ((this.getPrizeYear() == castOther.getPrizeYear()) || (this
						.getPrizeYear() != null
						&& castOther.getPrizeYear() != null && this
						.getPrizeYear().equals(castOther.getPrizeYear())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPrizeId() == null ? 0 : this.getPrizeId().hashCode());
		result = 37 * result
				+ (getFilm() == null ? 0 : this.getFilm().hashCode());
		result = 37 * result
				+ (getPrizeYear() == null ? 0 : this.getPrizeYear().hashCode());
		return result;
	}

}