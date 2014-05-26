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
 * Type entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "type", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "type"))
public class Type implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String type;
	private Set<FilmType> filmTypes = new HashSet<FilmType>(0);

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String type) {
		this.type = type;
	}

	/** full constructor */
	public Type(String type, Set<FilmType> filmTypes) {
		this.type = type;
		this.filmTypes = filmTypes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "type_id", unique = true, nullable = false)
	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@Column(name = "type", unique = true, nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "type")
	public Set<FilmType> getFilmTypes() {
		return this.filmTypes;
	}

	public void setFilmTypes(Set<FilmType> filmTypes) {
		this.filmTypes = filmTypes;
	}

}