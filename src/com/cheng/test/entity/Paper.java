package com.cheng.test.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Paper entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "paper", catalog = "mydb")
public class Paper implements java.io.Serializable {

	// Fields

	private Integer pid;
	private String papername;
	private String publication;
	private Date announcetime;
	private String level;
	private String author;
	private Integer tid;

	// Constructors

	/** default constructor */
	public Paper() {
	}

	/** minimal constructor */
	public Paper(String papername, String publication, Date announcetime,
			String level, String author) {
		this.papername = papername;
		this.publication = publication;
		this.announcetime = announcetime;
		this.level = level;
		this.author = author;
	}

	/** full constructor */
	public Paper(String papername, String publication, Date announcetime,
			String level, String author, Integer tid) {
		this.papername = papername;
		this.publication = publication;
		this.announcetime = announcetime;
		this.level = level;
		this.author = author;
		this.tid = tid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "pid", unique = true, nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "papername", nullable = false, length = 65535)
	public String getPapername() {
		return this.papername;
	}

	public void setPapername(String papername) {
		this.papername = papername;
	}

	@Column(name = "publication", nullable = false, length = 65535)
	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "announcetime", nullable = false, length = 0)
	public Date getAnnouncetime() {
		return this.announcetime;
	}

	public void setAnnouncetime(Date announcetime) {
		this.announcetime = announcetime;
	}

	@Column(name = "level", nullable = false, length = 65535)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "author", nullable = false, length = 65535)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "tid")
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}