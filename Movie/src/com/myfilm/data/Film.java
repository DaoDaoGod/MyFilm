package com.myfilm.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Film entity. @author MyEclipse Persistence Tools
 */

public class Film implements java.io.Serializable {

	// Fields

	private Integer filmId;
	private String name;
	private String description;
	private String director;
	private Integer duration;
	private Date update;
	private String dblink;
	private String imdblink;
	private Float hotgrade;
	private String othername;
	private Set photos = new HashSet(0);
	private Set filmActors = new HashSet(0);
	private Set downloads = new HashSet(0);
	private Set filmTypes = new HashSet(0);
	private Set viewlinks = new HashSet(0);
	private Set filmBoxoffices = new HashSet(0);
	private Set filmGroups = new HashSet(0);
	private Set filmPrizes = new HashSet(0);
	private Set filmUsers = new HashSet(0);
	private Set filmPlaces = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Film() {
	}

	/** minimal constructor */
	public Film(String name) {
		this.name = name;
	}

	/** full constructor */
	public Film(String name, String description, String director,
			Integer duration, Date update, String dblink, String imdblink,
			Float hotgrade, String othername, Set photos, Set filmActors,
			Set downloads, Set filmTypes, Set viewlinks, Set filmBoxoffices,
			Set filmGroups, Set filmPrizes, Set filmUsers, Set filmPlaces,
			Set comments) {
		this.name = name;
		this.description = description;
		this.director = director;
		this.duration = duration;
		this.update = update;
		this.dblink = dblink;
		this.imdblink = imdblink;
		this.hotgrade = hotgrade;
		this.othername = othername;
		this.photos = photos;
		this.filmActors = filmActors;
		this.downloads = downloads;
		this.filmTypes = filmTypes;
		this.viewlinks = viewlinks;
		this.filmBoxoffices = filmBoxoffices;
		this.filmGroups = filmGroups;
		this.filmPrizes = filmPrizes;
		this.filmUsers = filmUsers;
		this.filmPlaces = filmPlaces;
		this.comments = comments;
	}

	// Property accessors

	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getUpdate() {
		return this.update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public String getDblink() {
		return this.dblink;
	}

	public void setDblink(String dblink) {
		this.dblink = dblink;
	}

	public String getImdblink() {
		return this.imdblink;
	}

	public void setImdblink(String imdblink) {
		this.imdblink = imdblink;
	}

	public Float getHotgrade() {
		return this.hotgrade;
	}

	public void setHotgrade(Float hotgrade) {
		this.hotgrade = hotgrade;
	}

	public String getOthername() {
		return this.othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public Set getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set photos) {
		this.photos = photos;
	}

	public Set getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set filmActors) {
		this.filmActors = filmActors;
	}

	public Set getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Set downloads) {
		this.downloads = downloads;
	}

	public Set getFilmTypes() {
		return this.filmTypes;
	}

	public void setFilmTypes(Set filmTypes) {
		this.filmTypes = filmTypes;
	}

	public Set getViewlinks() {
		return this.viewlinks;
	}

	public void setViewlinks(Set viewlinks) {
		this.viewlinks = viewlinks;
	}

	public Set getFilmBoxoffices() {
		return this.filmBoxoffices;
	}

	public void setFilmBoxoffices(Set filmBoxoffices) {
		this.filmBoxoffices = filmBoxoffices;
	}

	public Set getFilmGroups() {
		return this.filmGroups;
	}

	public void setFilmGroups(Set filmGroups) {
		this.filmGroups = filmGroups;
	}

	public Set getFilmPrizes() {
		return this.filmPrizes;
	}

	public void setFilmPrizes(Set filmPrizes) {
		this.filmPrizes = filmPrizes;
	}

	public Set getFilmUsers() {
		return this.filmUsers;
	}

	public void setFilmUsers(Set filmUsers) {
		this.filmUsers = filmUsers;
	}

	public Set getFilmPlaces() {
		return this.filmPlaces;
	}

	public void setFilmPlaces(Set filmPlaces) {
		this.filmPlaces = filmPlaces;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}