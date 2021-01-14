package com.mmmit.online.shop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.mmit.online.shop.Category;
import com.mmit.online.shop.Customer;


public class CategoryService {
	private EntityManager em;
	public CategoryService(EntityManager em) {
		this.em=em;
	}
	public void createQueryInterface() {
	
		//Query interface (dynamic query)
		Query query1=em.createQuery("SELECT c FROM Category c");
				
		//TypedQuery interface (dynamic query)***dynamic query ဒါက  ပိုအသံုးမ်ားတယ္***
		TypedQuery<Category> query2=em.createQuery("SELECT c FROM Category c",Category.class);
				
				
		//Query interface (static query)
		Query query3=em.createNamedQuery("CategoryGetAll");
				
		//TypedQuery interface (static query)***static query ဒါက  ပိုအသံုးမ်ားတယ္***
		TypedQuery<Category> query4=em.createNamedQuery("CategoryGetAll", Category.class);
		
	}
	public List<Category> findById(int i, int j) {
		TypedQuery<Category> query=em.createQuery("SELECT c FROM Category c WHERE c.id>=:from and c.id<=:to", Category.class);
		query.setParameter("from", i);
		query.setParameter("to",j);
		
		return query.getResultList();
		
	}
	public List<String> findByNameEndWith2(String end) {
		TypedQuery<String> query=em.createQuery("SELECT c.name FROM Category c WHERE c.name LIKE :name", String.class);
		query.setParameter("name", end.concat("%"));
		return query.getResultList();
	}
	public void updateName(String newName, int id) {
		em.getTransaction().begin();
		
		Category c=em.find(Category.class, id);
		c.setName(newName);
		//em.remove(c);
		em.getTransaction().commit();
		
	}
	public Category findById(int i) {
		return em.find(Category.class, i);
	}
	public void deleteId(int id) {
		em.getTransaction().begin();
		Category c=em.find(Category.class, id);
		em.remove(c); // delete entity
		em.getTransaction().commit();
	}
	
}
