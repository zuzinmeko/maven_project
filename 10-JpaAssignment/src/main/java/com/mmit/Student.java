package com.mmit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.EnumType.STRING;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student implements Serializable {

	   
	@Id
	private int id;
	
	@Column(nullable = false,length=40)
	private String studentname;//not null,length-40
	
	@Column(unique = true)
	private String email;//unique
	
	private int age;
	@Enumerated(STRING)
	private Year role;//enum f,s,t,f,f
	public Year getRole() {
		return role;
	}
	public void setRole(Year role) {
		this.role = role;
	}

	private String address;
	private Date dob;
	private String profile;
	
	public enum Year{
		FirstYear,SecondYear,ThirdYear,FourthYear,FifthYear
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
   
}
