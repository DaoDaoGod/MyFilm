package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Prize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "prize", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "prizename"))
public class Prize implements java.io.Serializable {

	// Fields

	private PrizeId id;
	private String prizename;
	private Set<FilmPrize> filmPrizes = new HashSet<FilmPrize>(0);

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
	public Prize(PrizeId id, String prizename, Set<FilmPrize> filmPrizes) {
		this.id = id;
		this.prizename = prizename;
		this.filmPrizes = filmPrizes;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "prizeId", column = @Column(name = "prize_id", nullable = false)),
			@AttributeOverride(name = "year", column = @Column(name = "year", nullable = false)) })
	public PrizeId getId() {
		return this.id;
	}

	public void setId(PrizeId id) {
		this.id = id;
	}

	@Column(name = "prizename", unique = true, nullable = false, length = 45)
	public String getPrizename() {
		return this.prizename;
	}

	public void setPrizename(String prizename) {
		this.prizename = prizename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prize")
	public Set<FilmPrize> getFilmPrizes() {
		return this.filmPrizes;
	}

	public void setFilmPrizes(Set<FilmPrize> filmPrizes) {
		this.filmPrizes = filmPrizes;
	}

}