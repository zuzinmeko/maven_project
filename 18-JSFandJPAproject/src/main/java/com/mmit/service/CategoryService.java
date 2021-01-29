package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mmit.entity.Category;
@Stateless
public class CategoryService {
	
	@PersistenceContext
	private EntityManager em;
	public void saveCategory(Category category) {
		em.persist(category);
	}
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return em.createNamedQuery("Category.getAll",Category.class).getResultList();
	}
}
