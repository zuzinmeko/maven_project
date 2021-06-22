package com.mmit.beans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mmit.model.entity.Users;
import com.mmit.model.service.Userservice;



@RequestScoped
@Named
public class UserBean {
	@Inject
	private Userservice service;
	
	private Users user;
	
	@PostConstruct
	private void init() {
		user=new Users();
	}
	
	public  void checkLogIn() {
		service.findByLogInID(user.getLoginId());
		
		
		
	}
	
	public String login() {
		return null;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
