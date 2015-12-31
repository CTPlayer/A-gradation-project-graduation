package com.cheng.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Upload entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "upload", catalog = "mydb")
public class Upload implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String filename;
	private String videoname;
	private Integer lid;

	// Constructors

	/** default constructor */
	public Upload() {
	}

	/** minimal constructor */
	public Upload(String filename, String videoname) {
		this.filename = filename;
		this.videoname = videoname;
	}

	/** full constructor */
	public Upload(String filename, String videoname, Integer lid) {
		this.filename = filename;
		this.videoname = videoname;
		this.lid = lid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "uid", unique = true, nullable = false)
	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	@Column(name = "filename", nullable = false, length = 65535)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "videoname", nullable = false, length = 65535)
	public String getVideoname() {
		return this.videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	@Column(name = "lid")
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

}