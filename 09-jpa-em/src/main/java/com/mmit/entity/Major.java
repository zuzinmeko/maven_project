package com.mmit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Columns;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Major
 *
 */
@Entity
@Table(name="major")
public class Major implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name",nullable=false)
	private String majorName;
	
	private int fees;
	
	@Enumerated(STRING)
	private Level level;
	
	@Temporal(DATE)
	private Date startDate;
	
	
	public enum Level{
		basic,intermediate,advanced
	}

	public Major() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
   
}
