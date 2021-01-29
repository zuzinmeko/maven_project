package com.mmit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.mmit.entity.Category;
import com.mmit.service.CategoryService;

@Named
@RequestScoped

public class CategoryBean {
	private Category category;
	private List<Category> categorylist;
	@EJB
	private CategoryService service;
	
	@PostConstruct
	private void init() {
		category=new Category();
		categorylist=service.findAll();
	}
	
	public String save() {
		System.out.println("name :"+category.getName());
		service.saveCategory(category);
		return "home?faces-redirect=ture";
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategorylist() {
		return categorylist;
	}
	public void setCategorylist(List<Category> categorylist) {
		this.categorylist = categorylist;
	}
	
	

}
