package com.mmmit.online.shop.service;

import javax.persistence.EntityManager;

import com.mmit.online.shop.Sale;

public class SaleService {
	private EntityManager em;
	public SaleService(EntityManager em) {
		this.em=em;
	}
	public void save(Sale salerecord) {
		em.getTransaction().begin();
		em.persist(salerecord);
		em.getTransaction().commit();
		
	}
}