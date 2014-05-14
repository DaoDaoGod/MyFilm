package com.myfilm.data;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */

public class Photo implements java.io.Serializable {

	// Fields

	private PhotoId id;
	private String photolink;
	private Boolean ismainphoto;
	private String photocol;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** minimal constructor */
	public Photo(PhotoId id, String photolink) {
		this.id = id;
		this.photolink = photolink;
	}

	/** full constructor */
	public Photo(PhotoId id, String photolink, Boolean ismainphoto,
			String photocol) {
		this.id = id;
		this.photolink = photolink;
		this.ismainphoto = ismainphoto;
		this.photocol = photocol;
	}

	// Property accessors

	public PhotoId getId() {
		return this.id;
	}

	public void setId(PhotoId id) {
		this.id = id;
	}

	public String getPhotolink() {
		return this.photolink;
	}

	public void setPhotolink(String photolink) {
		this.photolink = photolink;
	}

	public Boolean getIsmainphoto() {
		return this.ismainphoto;
	}

	public void setIsmainphoto(Boolean ismainphoto) {
		this.ismainphoto = ismainphoto;
	}

	public String getPhotocol() {
		return this.photocol;
	}

	public void setPhotocol(String photocol) {
		this.photocol = photocol;
	}

}