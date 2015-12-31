package com.cheng.test.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "teacher", catalog = "mydb")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String username;
	private String password;
	private String qq;
	private String email;
	private String institute;
	private String resource;
	
	private Set<Lessions> lessions = new HashSet<Lessions>();
	private Set<Paper> paper = new HashSet<Paper>();
	private Set<Item> item = new HashSet<Item>();
	private Blog blog = new Blog();
	private Set<Bbs> bbs = new HashSet<Bbs>();
	private Set<Answer> answer = new HashSet<Answer>();
	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(String username, String password, String qq, String email,
			String institute) {
		this.username = username;
		this.password = password;
		this.qq = qq;
		this.email = email;
		this.institute = institute;
	}

	/** full constructor */
	public Teacher(String username, String password, String qq, String email,
			String institute, String resource) {
		this.username = username;
		this.password = password;
		this.qq = qq;
		this.email = email;
		this.institute = institute;
		this.resource = resource;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "tid", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "username", nullable = false, length = 65535)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 65535)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "qq", nullable = false, length = 65535)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "email", nullable = false, length = 65535)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "institute", nullable = false, length = 65535)
	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	@Column(name = "resource", length = 65535)
	public String getResource() {
		return this.resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tid")
	public Set<Lessions> getLessions() {
		return lessions;
	}

	public void setLessions(Set<Lessions> lessions) {
		this.lessions = lessions;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tid")
	public Set<Paper> getPaper() {
		return paper;
	}

	public void setPaper(Set<Paper> paper) {
		this.paper = paper;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tid")
	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tid")
	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER,mappedBy="teacher")
	public Set<Bbs> getBbs() {
		return bbs;
	}

	public void setBbs(Set<Bbs> bbs) {
		this.bbs = bbs;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER,mappedBy="teacher")
	public Set<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}

	
	
}