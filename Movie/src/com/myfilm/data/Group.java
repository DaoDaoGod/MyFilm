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
 * Group entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "group_name"))
public class Group implements java.io.Serializable {

	// Fields

	private Integer groupId;
	private String groupName;
	private String groupDescription;
	private String groupOwner;
	private Integer droupNumber;
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);
	private Set<GroupComment> groupComments = new HashSet<GroupComment>(0);
	private Set<Topic> topics = new HashSet<Topic>(0);
	private Set<FilmGroup> filmGroups = new HashSet<FilmGroup>(0);

	// Constructors

	/** default constructor */
	public Group() {
	}

	/** minimal constructor */
	public Group(String groupName) {
		this.groupName = groupName;
	}

	/** full constructor */
	public Group(String groupName, String groupDescription, String groupOwner,
			Integer droupNumber, Set<UserGroup> userGroups,
			Set<GroupComment> groupComments, Set<Topic> topics,
			Set<FilmGroup> filmGroups) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.groupOwner = groupOwner;
		this.droupNumber = droupNumber;
		this.userGroups = userGroups;
		this.groupComments = groupComments;
		this.topics = topics;
		this.filmGroups = filmGroups;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "group_id", unique = true, nullable = false)
	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "group_name", unique = true, nullable = false, length = 45)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "group_description")
	public String getGroupDescription() {
		return this.groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	@Column(name = "group_owner", length = 45)
	public String getGroupOwner() {
		return this.groupOwner;
	}

	public void setGroupOwner(String groupOwner) {
		this.groupOwner = groupOwner;
	}

	@Column(name = "droup_number")
	public Integer getDroupNumber() {
		return this.droupNumber;
	}

	public void setDroupNumber(Integer droupNumber) {
		this.droupNumber = droupNumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public Set<UserGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public Set<GroupComment> getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set<GroupComment> groupComments) {
		this.groupComments = groupComments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public Set<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public Set<FilmGroup> getFilmGroups() {
		return this.filmGroups;
	}

	public void setFilmGroups(Set<FilmGroup> filmGroups) {
		this.filmGroups = filmGroups;
	}

}