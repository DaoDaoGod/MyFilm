package com.myfilm.data;

/**
 * Viewlink entity. @author MyEclipse Persistence Tools
 */

public class Viewlink implements java.io.Serializable {

	// Fields

	private ViewlinkId id;
	private String viewlink;

	// Constructors

	/** default constructor */
	public Viewlink() {
	}

	/** full constructor */
	public Viewlink(ViewlinkId id, String viewlink) {
		this.id = id;
		this.viewlink = viewlink;
	}

	// Property accessors

	public ViewlinkId getId() {
		return this.id;
	}

	public void setId(ViewlinkId id) {
		this.id = id;
	}

	public String getViewlink() {
		return this.viewlink;
	}

	public void setViewlink(String viewlink) {
		this.viewlink = viewlink;
	}

}