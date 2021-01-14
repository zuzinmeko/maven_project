package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.mmit.online.shop.Customer;
import com.mmmit.online.shop.service.CustomerService;
@TestMethodOrder(OrderAnnotation.class)
class CustomerTesting {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private CustomerService service;
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
		service=new CustomerService(em);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}
	
	//@Test
	void updateEmailCustomer() {
		service.updateEmail("zuzuin@gmail.com", 1);
		Customer cust=service.findById(1);
		//assertEquals("zz@gmail.com", cust.getEmail());
	}
	
	//@Test
	void updateEmail() {
		//service.updateEmail("mhmk@gmail.com", 1);
		//String mail=service.findById(1);
		//assertEquals("mhmk@gmail.com", mail);
	}
	//@Test
	void retrieveCustomerName() {
		List<String> list=service.searchWithLikeOperator("z");
		list.forEach(name->System.out.println(name));
	}
	//@Test
	void retrieve_customerEmail(){
		List<String> list=service.findByEmailStartWith("t");
		list.forEach(c->{
			System.out.println(c);
		});
	}
	//@Test
	void retrieve_noOfCustomerCount() {
		long total=service.getNoOfCustomers();
		System.out.println("Total :"+total);
	}
	//@Test
	void retrieve_customerById() {
		List<Customer> list=service.findById(2,5);
		
		list.forEach(c->{
			System.out.println(c.getName()+"\t"+c.getId());
		});
	}
	
	//@Test
	void retrieve_test(){
		List<Customer> list=service.findByName("thient thient");
		if(list!=null)
		System.out.println("list: "+list.get(0).getEmail());
	}
	
	//@Test
	void test_orderby_customer(){
		TypedQuery<Customer> query=em.createQuery("SELECT c FROM Customer c ORDER BY c.name DESC", Customer.class);
		List<Customer> list=query.getResultList();
		for (Customer customer : list) {
			System.out.println(customer.getName());
		}
	}
	
	
	//@Test
	@Order(1)
	void test_customers() {
		service.createQueryInterface();
	}
	
	
	//@Test
	@Order(2)
	void test_singleResult() {
		//Query interface (dynamic query)
		Query query1=em.createQuery("SELECT c FROM Customer c");
		//Customer c=(Customer) query1.getSingleResult();
		//List<Customer> list=query1.getResultList();
		
		TypedQuery<Customer> query2=em.createQuery("SELECT c FROM Customer c",Customer.class);
		//List<Customer> list=query2.getResultList();
		TypedQuery<Customer> query3=em.createQuery("SELECT c FROM Customer c WHERE c.id=2",Customer.class);
		Customer c=query3.getSingleResult();//1
		
		List<Customer> list=query3.getResultList();//2
		System.out.println("list"+list.size());
		Customer c1=list.get(0);
		
		assertEquals("4564345", c1.getPassword());
		//assertEquals(5, list.size());
	}

}
