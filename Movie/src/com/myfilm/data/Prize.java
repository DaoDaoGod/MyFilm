package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Prize entity. @author MyEclipse Persistence Tools
 */

public class Prize implements java.io.Serializable {

	// Fields

	private PrizeId id;
	private String prizename;
	private Set filmPrizes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Prize() {
	}

	/** minimal constructor */
	public Prize(PrizeId id, String prizename) {
		this.id = id;
		this.prizename = prizename;
	}

	/** full constructor */
	public Prize(PrizeId id, String prizename, Set filmPrizes) {
		this.id = id;
		this.prizename = prizename;
		this.filmPrizes = filmPrizes;
	}

	// Property accessors

	public PrizeId getId() {
		return this.id;
	}

	public void setId(PrizeId id) {
		this.id = id;
	}

	public String getPrizename() {
		return this.prizename;
	}

	public void setPrizename(String prizename) {
		this.prizename = prizename;
	}

	public Set getFilmPrizes() {
		return this.filmPrizes;
	}

	public void setFilmPrizes(Set filmPrizes) {
		this.filmPrizes = filmPrizes;
	}

}