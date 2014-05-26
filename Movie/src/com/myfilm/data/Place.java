package com.myfilm.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Place entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "place", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "place"))
public class Place implements java.io.Serializable {

	// Fields

	private Integer placeId;
	private String place;
	private Set<FilmPlace> filmPlaces = new HashSet<FilmPlace>(0);

	// Constructors

	/** default constructor */
	public Place() {
	}

	/** minimal constructor */
	public Place(String place) {
		this.place = place;
	}

	/** full constructor */
	public Place(String place, Set<FilmPlace> filmPlaces) {
		this.place = place;
		this.filmPlaces = filmPlaces;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "place_id", unique = true, nullable = false)
	public Integer getPlaceId() {
		return this.placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	@Column(name = "place", unique = true, nullable = false, length = 45)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "place")
	public Set<FilmPlace> getFilmPlaces() {
		return this.filmPlaces;
	}

	public void setFilmPlaces(Set<FilmPlace> filmPlaces) {
		this.filmPlaces = filmPlaces;
	}

}