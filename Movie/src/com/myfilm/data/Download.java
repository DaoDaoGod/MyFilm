package com.myfilm.data;

/**
 * Download entity. @author MyEclipse Persistence Tools
 */

public class Download implements java.io.Serializable {

	// Fields

	private DownloadId id;
	private String dowloadLink;

	// Constructors

	/** default constructor */
	public Download() {
	}

	/** full constructor */
	public Download(DownloadId id, String dowloadLink) {
		this.id = id;
		this.dowloadLink = dowloadLink;
	}

	// Property accessors

	public DownloadId getId() {
		return this.id;
	}

	public void setId(DownloadId id) {
		this.id = id;
	}

	public String getDowloadLink() {
		return this.dowloadLink;
	}

	public void setDowloadLink(String dowloadLink) {
		this.dowloadLink = dowloadLink;
	}

}