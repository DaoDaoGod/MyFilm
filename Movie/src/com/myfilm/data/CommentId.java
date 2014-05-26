package com.myfilm.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CommentId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CommentId implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer userId;
	private Integer filmId;

	// Constructors

	/** default constructor */
	public CommentId() {
	}

	/** full constructor */
	public CommentId(Integer commentId, Integer userId, Integer filmId) {
		this.commentId = commentId;
		this.userId = userId;
		this.filmId = filmId;
	}

	// Property accessors

	@Column(name = "comment_id", nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "film_id", nullable = false)
	public Integer getFilmId() {
		return this.filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return ((this.getCommentId() == castOther.getCommentId()) || (this
				.getCommentId() != null && castOther.getCommentId() != null && this
				.getCommentId().equals(castOther.getCommentId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getFilmId() == castOther.getFilmId()) || (this
						.getFilmId() != null && castOther.getFilmId() != null && this
						.getFilmId().equals(castOther.getFilmId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCommentId() == null ? 0 : this.getCommentId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getFilmId() == null ? 0 : this.getFilmId().hashCode());
		return result;
	}

}