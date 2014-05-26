package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FilmPrizeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FilmPrizeId implements java.io.Serializable {

	// Fields

	private Integer prizeId;
	private Integer filmId;
	private Integer prizeYear;

	// Constructors

	/** default constructor */
	public FilmPrizeId() {
	}

	/** full constructor */
	public FilmPrizeId(Integer prizeId, Integer filmId, Integer prizeYear) {
		this.prizeId = prizeId;
		this.filmId = filmId;
		this.prizeYear = prizeYear;
	}

	// Property accessors

	@Column(name = "prize_id", nullable = false)
	public Integer getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Column(name = "prize_year", nullable = false)
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
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())))
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
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		result = 37 * result
				+ (getPrizeYear() == null ? 0 : this.getPrizeYear().hashCode());
		return result;
	}

}