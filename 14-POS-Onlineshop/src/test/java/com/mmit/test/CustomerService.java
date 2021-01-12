package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.online.shop.Customer;

class CustomerService {
	private static EntityManagerFactory emf;
	private EntityManager em;
	
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
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_customers() {
		//Query interface (dynamic query)
		Query query1=em.createQuery("SELECT c FROM Customer c");
		
		//TypedQuery interface (dynamic query)***dynamic query ဒါက  ပိုအသံုးမ်ားတယ္***
		TypedQuery<Customer> query2=em.createQuery("SELECT c FROM Customer c",Customer.class);
		
		
		//Query interface (static query)
		Query query3=em.createNamedQuery("CustomerGetAll");
		
		//TypedQuery interface (static query)***static query ဒါက  ပိုအသံုးမ်ားတယ္***
		TypedQuery<Customer> query4=em.createNamedQuery("CustomerGetAll", Customer.class);
	
		
		
	}

}
