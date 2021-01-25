package com.mmit.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("user_bean")
public class UserBean {
	private String username;
	private String password;
	private String dob;
	private int age;
	private String township;
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTownship() {
		return township;
	}
	public void setTownship(String township) {
		this.township = township;
	}
	
	
}
