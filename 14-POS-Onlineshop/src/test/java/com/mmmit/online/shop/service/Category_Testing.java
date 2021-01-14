package com.mmmit.online.shop.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.online.shop.Category;
import com.mmit.online.shop.Customer;

class Category_Testing {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CategoryService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("onlineshop");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em=emf.createEntityManager();
		service=new CategoryService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	//@Test
	void test() {
		service.createQueryInterface();
	}
	//@Test
	void retrieve_categoryById() {
		List<Category> list=service.findById(2,5);
		
		list.forEach(c->{
			System.out.println(c.getName()+"\t"+c.getId());
		});
	}
	//@Test
	void test_orderby_category(){
		TypedQuery<Category> query=em.createQuery("SELECT c FROM Category c ORDER BY c.name DESC", Category.class);
		List<Category> list=query.getResultList();
		for (Category category : list) {
			System.out.println(category.getName());
		}
	}
	//@Test
	void retrieve_categoryName(){
		List<String> list=service.findByNameEndWith2("s");
		list.forEach(c->{
			System.out.println(c);
		});
	}
	//@Test
	void updateName() {
		service.updateName("fruit", 1);
		Category category=service.findById(1);
		
	}
	//@Test
	void deleteId() {
		service.deleteId(5);
		Category category=service.findById(5);
	}
	
}
