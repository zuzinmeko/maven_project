package com.mmit.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.entity.Major.Level;

@TestMethodOrder(OrderAnnotation.class)
class entitymanager_test {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf=Persistence.createEntityManagerFactory("jpa");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		if(emf!=null && emf.isOpen())
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
	
	//insert method -persist method//
	//=============================//
	@Order(1)
	@Test
	public void entity_state_test(){
		//create entity or object
		Major m=new Major();// this is transient entity or new state
		m.setMajorName("php");
		m.setFees(300000);
		m.setLevel(Level.intermediate);
		m.setStartDate(Date.valueOf(LocalDate.now()));
		
		em.getTransaction().begin();
		em.persist(m);//persistent state - managed entity
		em.getTransaction().commit();
		
		assertEquals(1,m.getId());
	}
	
	//find state
	//===========
	@Order(2)
	@Test
	public void entity_find() {
		Major m=em.find(Major.class, 1);
		assertNotNull(m);
	}
	
	//Update state
	//============
	@Order(3)
	@Test
	public void test1() {
		Major m=em.find(Major.class, 1);
		em.getTransaction().begin();
		m.setFees(400000);
		em.getTransaction().commit();
		assertEquals(400000,m.getFees());
	}
	
	@Order(4)
	@Test
	public void test2() {
		Major m=em.find(Major.class, 1);
		//em.detach(m);//detach (un-managed)
		//em.clear();
		
		em.getTransaction().begin();
		m.setFees(400000);
		em.getTransaction().commit();
		
		Major m1=em.find(Major.class, 1);
		assertEquals(400000,m1.getFees());
	}
	
	@Order(5)
	@Test
	public void test3() {
		Major m=em.find(Major.class, 1);
		em.clear();
		
		em.getTransaction().begin();
		Major m1=em.merge(m);
		m1.setFees(500000);
		m1.setMajorName("java ee");
		em.getTransaction().commit();
	}
	
	//remove un managed entity
	//=========================
	//@Order(6)
	//@Test
	public void test4() {
		Major m=em.find(Major.class, 1);
		em.clear();
		
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		
	}
	
	//Delete statement
	//=================
	@Order(7)
	@Test
	public void test5() {
		Major m=em.find(Major.class, 1);
		em.getTransaction().begin();
		em.remove(m);//remove
		em.getTransaction().commit();
		
		Major m1=em.find(Major.class, 1);
		
		assertNull(m1);
	}
}
