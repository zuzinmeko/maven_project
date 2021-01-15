package com.mmit.online.shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Orders
 *
 */
@Entity

public class Sale implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate saleDate;
	
	@OneToMany(mappedBy = "sale", cascade = { PERSIST, MERGE, REMOVE })
	private List<SaleDetail> detaillist=new ArrayList<>();
	
	public void addSaleItem(SaleDetail s) {
		s.setSale(this);
		detaillist.add(s);
	}
	public Sale() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}
	public List<SaleDetail> getDetaillist() {
		return detaillist;
	}
	public void setDetaillist(List<SaleDetail> detaillist) {
		this.detaillist = detaillist;
	}
   
}
