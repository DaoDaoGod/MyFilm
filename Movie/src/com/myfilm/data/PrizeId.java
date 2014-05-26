package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PrizeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PrizeId implements java.io.Serializable {

	// Fields

	private Integer prizeId;
	private Integer year;

	// Constructors

	/** default constructor */
	public PrizeId() {
	}

	/** full constructor */
	public PrizeId(Integer prizeId, Integer year) {
		this.prizeId = prizeId;
		this.year = year;
	}

	// Property accessors

	@Column(name = "prize_id", nullable = false)
	public Integer getPrizeId() {
		return this.prizeId;
	}

	public void setPrizeId(Integer prizeId) {
		this.prizeId = prizeId;
	}

	@Column(name = "year", nullable = false)
	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PrizeId))
			return false;
		PrizeId castOther = (PrizeId) other;

		return ((this.getPrizeId() == castOther.getPrizeId()) || (this
				.getPrizeId() != null && castOther.getPrizeId() != null && this
				.getPrizeId().equals(castOther.getPrizeId())))
				&& ((this.getYear() == castOther.getYear()) || (this.getYear() != null
						&& castOther.getYear() != null && this.getYear()
						.equals(castOther.getYear())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPrizeId() == null ? 0 : this.getPrizeId().hashCode());
		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		return result;
	}

}