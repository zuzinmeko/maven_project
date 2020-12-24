package com.mmit;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.TemporalType.TIME;
import static javax.persistence.TemporalType.TIMESTAMP;
import static javax.persistence.EnumType.STRING;

/**
 * Entity implementation class for Entity: Course
 *
 */
@Entity

public class Course implements Serializable {

	   
	@Id
	private Integer id;
	
	
	@Column(unique = true)
	private String coursename;
	private int price;
	@Basic(fetch = LAZY)
	@Enumerated(STRING)
	private Level role;//enum Basic,Intermediate,Advance
	
	
	public Level getRole() {
		return role;
	}
	public void setRole(Level role) {
		this.role = role;
	}

	private int duration;
	private Date startDate;
	
	
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	private static final long serialVersionUID = 1L;
	
	public enum Level{
		Basic,Intermediate,Advanced
	}

	public Course() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
}
