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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Lessions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lessions", catalog = "mydb")
public class Lessions implements java.io.Serializable {

	// Fields

	private Integer lid;
	private String subject;
	private String type;
	private String property;
	private String major;
	private String remark;
	private Integer tid;
	
	private Set<Upload> upload = new HashSet<Upload>();

	// Constructors

	/** default constructor */
	public Lessions() {
	}

	/** minimal constructor */
	public Lessions(String subject, String type, String property, String major,
			String remark) {
		this.subject = subject;
		this.type = type;
		this.property = property;
		this.major = major;
		this.remark = remark;
	}

	/** full constructor */
	public Lessions(String subject, String type, String property, String major,
			String remark, Integer tid) {
		this.subject = subject;
		this.type = type;
		this.property = property;
		this.major = major;
		this.remark = remark;
		this.tid = tid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "lid", unique = true, nullable = false)
	public Integer getLid() {
		return this.lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	@Column(name = "subject", nullable = false, length = 65535)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "type", nullable = false, length = 65535)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "property", nullable = false, length = 65535)
	public String getProperty() {
		return this.property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@Column(name = "major", nullable = false, length = 65535)
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "remark", nullable = false, length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "tid")
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="lid")
	public Set<Upload> getUpload() {
		return upload;
	}

	public void setUpload(Set<Upload> upload) {
		this.upload = upload;
	}

}