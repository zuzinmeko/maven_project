package com.mmit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
public class Student implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	
	@Column(name="student_name")
	private String username;
	
	@Column(name = "mail",
			nullable = false,
			length = 30, 
			unique = true)
	private String email;
	
	
	@Temporal(DATE)
	private Date dob;
	
	@Embedded
	private Address address;
	
	
	@Transient
	private boolean is_active;
	
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
