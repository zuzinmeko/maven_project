package com.mmit.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.online.shop.Item;
import com.mmit.online.shop.Sale;
import com.mmit.online.shop.SaleDetail;
import com.mmmit.online.shop.service.ItemService;
import com.mmmit.online.shop.service.SaleService;

class SaleTesting {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private SaleService service;
	private ItemService itemservice;
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
		service=new SaleService(em);
		itemservice=new ItemService(em);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test() {
		//sell two items
		Item item1=itemservice.findById(1);
		//Item item2=itemservice.findById(2);
		
		//2 records purchase
		SaleDetail d1=new SaleDetail();
		d1.setItem(item1);
		d1.setSubQty(20);
		
//		SaleDetail d2=new SaleDetail();
//		d2.setItem(item2);
//		d2.setSubQty(5);

		
		Sale salerecord=new Sale();
		salerecord.setSaleDate(LocalDate.now());
		salerecord.addSaleItem(d1);
		//salerecord.addSaleItem(d2);
		service.save(salerecord);
		
		
	}

}
