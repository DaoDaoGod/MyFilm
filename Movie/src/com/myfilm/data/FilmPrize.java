package com.myfilm.data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FilmPrize entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film_prize", catalog = "mydb")
public class FilmPrize implements java.io.Serializable {

	// Fields

	private FilmPrizeId id;
	private Prize prize;
	private Film film;

	// Constructors

	/** default constructor */
	public FilmPrize() {
	}

	/** full constructor */
	public FilmPrize(FilmPrizeId id, Prize prize, Film film) {
		this.id = id;
		this.prize = prize;
		this.film = film;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "prizeId", column = @Column(name = "prize_id", nullable = false)),
			@AttributeOverride(name = "filmId", column = @Column(name = "film_id", nullable = false)),
			@AttributeOverride(name = "prizeYear", column = @Column(name = "prize_year", nullable = false)) })
	public FilmPrizeId getId() {
		return this.id;
	}

	public void setId(FilmPrizeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "prize_id", referencedColumnName = "prize_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "prize_year", referencedColumnName = "year", nullable = false, insertable = false, updatable = false) })
	public Prize getPrize() {
		return this.prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id", nullable = false, insertable = false, updatable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}