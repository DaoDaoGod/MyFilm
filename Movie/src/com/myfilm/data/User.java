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
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "mydb", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String email;
	private String password;
	private String nickname;
	private Boolean gender;
	private Date birthday;
	private Integer userphoto;
	private Set<GroupComment> groupComments = new HashSet<GroupComment>(0);
	private Set<UserGroup> userGroups = new HashSet<UserGroup>(0);
	private Set<FilmUser> filmUsers = new HashSet<FilmUser>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email) {
		this.email = email;
	}

	/** full constructor */
	public User(String email, String password, String nickname, Boolean gender,
			Date birthday, Integer userphoto, Set<GroupComment> groupComments,
			Set<UserGroup> userGroups, Set<FilmUser> filmUsers,
			Set<Comment> comments) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.userphoto = userphoto;
		this.groupComments = groupComments;
		this.userGroups = userGroups;
		this.filmUsers = filmUsers;
		this.comments = comments;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname", length = 45)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "gender")
	public Boolean getGender() {
		return this.gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "userphoto")
	public Integer getUserphoto() {
		return this.userphoto;
	}

	public void setUserphoto(Integer userphoto) {
		this.userphoto = userphoto;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<GroupComment> getGroupComments() {
		return this.groupComments;
	}

	public void setGroupComments(Set<GroupComment> groupComments) {
		this.groupComments = groupComments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<UserGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<FilmUser> getFilmUsers() {
		return this.filmUsers;
	}

	public void setFilmUsers(Set<FilmUser> filmUsers) {
		this.filmUsers = filmUsers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}