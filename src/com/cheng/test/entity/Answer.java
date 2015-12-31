package com.cheng.test.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "answer", catalog = "mydb")
public class Answer implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String retxt;
	private Date retime;
	private Integer bbsid;
//	private Integer tid;
	
	private Teacher teacher;
//	private Bbs bbs;

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** full constructor */
	public Answer(String retxt, Date retime, Integer bbsid, Integer tid) {
		this.retxt = retxt;
		this.retime = retime;
		this.bbsid = bbsid;
//		this.tid = tid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "aid", unique = true, nullable = false)
	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	@Column(name = "retxt", nullable = false, length = 65535)
	public String getRetxt() {
		return this.retxt;
	}

	public void setRetxt(String retxt) {
		this.retxt = retxt;
	}

	@Column(name = "retime", nullable = false, length = 0)
	public Date getRetime() {
		return this.retime;
	}

	public void setRetime(Date retime) {
		this.retime = retime;
	}

	@Column(name = "bbsid")
	public Integer getBbsid() {
		return this.bbsid;
	}

	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}

//	@Column(name = "tid", nullable = false)
//	public Integer getTid() {
//		return this.tid;
//	}
//
//	public void setTid(Integer tid) {
//		this.tid = tid;
//	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tid")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="bbsid")
//	public Bbs getBbs() {
//		return bbs;
//	}
//
//	public void setBbs(Bbs bbs) {
//		this.bbs = bbs;
//	}

	
	
	
}