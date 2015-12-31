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
 * Item entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "item", catalog = "mydb")
public class Item implements java.io.Serializable {

	// Fields

	private Integer iid;
	private String itemname;
	private Date itemtime;
	private String support;
	private String remark;
	private Integer tid;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String itemname, Date itemtime, String support) {
		this.itemname = itemname;
		this.itemtime = itemtime;
		this.support = support;
	}

	/** full constructor */
	public Item(String itemname, Date itemtime, String support, String remark,
			Integer tid) {
		this.itemname = itemname;
		this.itemtime = itemtime;
		this.support = support;
		this.remark = remark;
		this.tid = tid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "iid", unique = true, nullable = false)
	public Integer getIid() {
		return this.iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	@Column(name = "itemname", nullable = false, length = 65535)
	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "itemtime", nullable = false, length = 0)
	public Date getItemtime() {
		return this.itemtime;
	}

	public void setItemtime(Date itemtime) {
		this.itemtime = itemtime;
	}

	@Column(name = "support", nullable = false, length = 65535)
	public String getSupport() {
		return this.support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	@Column(name = "remark", length = 65535)
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

}