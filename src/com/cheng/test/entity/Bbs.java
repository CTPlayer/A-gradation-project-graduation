package com.cheng.test.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Bbs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bbs", catalog = "mydb")
public class Bbs implements java.io.Serializable {

	// Fields

	private Integer bbsid;
	private String title;
	private Date times;
	private String txt;
	
	private Set<Answer> answer = new HashSet<Answer>();
	private Teacher teacher;
	private User user;

	// Constructors

	/** default constructor */
	public Bbs() {
	}

	/** minimal constructor */
	public Bbs(String title, Date times, String txt) {
		this.title = title;
		this.times = times;
		this.txt = txt;
	}

	/** full constructor */
	public Bbs(String title, Date times, String txt, Integer id, Integer tid) {
		this.title = title;
		this.times = times;
		this.txt = txt;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "bbsid", unique = true, nullable = false)
	public Integer getBbsid() {
		return this.bbsid;
	}

	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}

	@Column(name = "title", nullable = false, length = 65535)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "times", nullable = false, length = 0)
	public Date getTimes() {
		return this.times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	@Column(name = "txt", nullable = false, length = 65535)
	public String getTxt() {
		return this.txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@ManyToOne
	@JoinColumn(name="tid")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@ManyToOne
	@JoinColumn(name="id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="bbsid")
	public Set<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}
	
	
}