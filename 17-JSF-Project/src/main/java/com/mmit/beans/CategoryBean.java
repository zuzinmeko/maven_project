package com.mmit.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CategoryBean {
	private List<String> categories=new ArrayList<>();
	
	@PostConstruct
	private void initialize() {
		categories.add("fruit");
		categories.add("drink");
		categories.add("noddle");
		categories.add("elctronic");
		categories.add("snacks");
	}
	public CategoryBean() {
		categories=new ArrayList<>();
		
	}
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	

}
