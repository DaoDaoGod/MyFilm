package com.myfilm.data;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Film entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "film", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Film implements java.io.Serializable {

	// Fields

	private Integer filmId;
	private String name;
	private String description;
	private String director;
	private Integer duration;
	private Date update;
	private String dblink;
	private Float dbgrade;
	private Integer hotgrade;
	private String othername;
	private Set<Photo> photos = new HashSet<Photo>(0);
	private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);
	private Set<Download> downloads = new HashSet<Download>(0);
	private Set<FilmType> filmTypes = new HashSet<FilmType>(0);
	private Set<Viewlink> viewlinks = new HashSet<Viewlink>(0);
	private Set<FilmBoxoffice> filmBoxoffices = new HashSet<FilmBoxoffice>(0);
	private Set<FilmGroup> filmGroups = new HashSet<FilmGroup>(0);
	private Set<FilmPrize> filmPrizes = new HashSet<FilmPrize>(0);
	private Set<FilmUser> filmUsers = new HashSet<FilmUser>(0);
	private Set<FilmPlace> filmPlaces = new HashSet<FilmPlace>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

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
			Integer duration, Date update, String dblink, Float dbgrade,
			Integer hotgrade, String othername, Set<Photo> photos,
			Set<FilmActor> filmActors, Set<Download> downloads,
			Set<FilmType> filmTypes, Set<Viewlink> viewlinks,
			Set<FilmBoxoffice> filmBoxoffices, Set<FilmGroup> filmGroups,
			Set<FilmPrize> filmPrizes, Set<FilmUser> filmUsers,
			Set<FilmPlace> filmPlaces, Set<Comment> comments) {
		this.name = name;
		this.description = description;
		this.director = director;
		this.duration = duration;
		this.update = update;
		this.dblink = dblink;
		this.dbgrade = dbgrade;
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
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "film_id", unique = true, nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "director", length = 45)
	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "update", length = 10)
	public Date getUpdate() {
		return this.update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	@Column(name = "dblink")
	public String getDblink() {
		return this.dblink;
	}

	public void setDblink(String dblink) {
		this.dblink = dblink;
	}

	@Column(name = "dbgrade", precision = 12, scale = 0)
	public Float getDbgrade() {
		return this.dbgrade;
	}

	public void setDbgrade(Float dbgrade) {
		this.dbgrade = dbgrade;
	}

	@Column(name = "hotgrade")
	public Integer getHotgrade() {
		return this.hotgrade;
	}

	public void setHotgrade(Integer hotgrade) {
		this.hotgrade = hotgrade;
	}

	@Column(name = "othername")
	public String getOthername() {
		return this.othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Download> getDownloads() {
		return this.downloads;
	}

	public void setDownloads(Set<Download> downloads) {
		this.downloads = downloads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmType> getFilmTypes() {
		return this.filmTypes;
	}

	public void setFilmTypes(Set<FilmType> filmTypes) {
		this.filmTypes = filmTypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Viewlink> getViewlinks() {
		return this.viewlinks;
	}

	public void setViewlinks(Set<Viewlink> viewlinks) {
		this.viewlinks = viewlinks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmBoxoffice> getFilmBoxoffices() {
		return this.filmBoxoffices;
	}

	public void setFilmBoxoffices(Set<FilmBoxoffice> filmBoxoffices) {
		this.filmBoxoffices = filmBoxoffices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmGroup> getFilmGroups() {
		return this.filmGroups;
	}

	public void setFilmGroups(Set<FilmGroup> filmGroups) {
		this.filmGroups = filmGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmPrize> getFilmPrizes() {
		return this.filmPrizes;
	}

	public void setFilmPrizes(Set<FilmPrize> filmPrizes) {
		this.filmPrizes = filmPrizes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmUser> getFilmUsers() {
		return this.filmUsers;
	}

	public void setFilmUsers(Set<FilmUser> filmUsers) {
		this.filmUsers = filmUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<FilmPlace> getFilmPlaces() {
		return this.filmPlaces;
	}

	public void setFilmPlaces(Set<FilmPlace> filmPlaces) {
		this.filmPlaces = filmPlaces;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}