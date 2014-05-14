package com.myfilm.data;

/**
 * BoxofficeId entity. @author MyEclipse Persistence Tools
 */

public class BoxofficeId implements java.io.Serializable {

	// Fields

	private Integer boxofficeId;
	private Integer weeks;

	// Constructors

	/** default constructor */
	public BoxofficeId() {
	}

	/** full constructor */
	public BoxofficeId(Integer boxofficeId, Integer weeks) {
		this.boxofficeId = boxofficeId;
		this.weeks = weeks;
	}

	// Property accessors

	public Integer getBoxofficeId() {
		return this.boxofficeId;
	}

	public void setBoxofficeId(Integer boxofficeId) {
		this.boxofficeId = boxofficeId;
	}

	public Integer getWeeks() {
		return this.weeks;
	}

	public void setWeeks(Integer weeks) {
		this.weeks = weeks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BoxofficeId))
			return false;
		BoxofficeId castOther = (BoxofficeId) other;

		return ((this.getBoxofficeId() == castOther.getBoxofficeId()) || (this
				.getBoxofficeId() != null && castOther.getBoxofficeId() != null && this
				.getBoxofficeId().equals(castOther.getBoxofficeId())))
				&& ((this.getWeeks() == castOther.getWeeks()) || (this
						.getWeeks() != null && castOther.getWeeks() != null && this
						.getWeeks().equals(castOther.getWeeks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getBoxofficeId() == null ? 0 : this.getBoxofficeId()
						.hashCode());
		result = 37 * result
				+ (getWeeks() == null ? 0 : this.getWeeks().hashCode());
		return result;
	}

}