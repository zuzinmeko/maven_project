package com.mmit.pos.model.entity;

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

@Table(name="sale")
@NamedQuery(name = "Sale.getAll", query = "SELECT s FROM Sale s ORDER BY s.sale_date DESC")
public class Sale implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate sale_date;
	
	@OneToMany(mappedBy = "sale", cascade = { PERSIST, MERGE, REMOVE })
	private List<SaleDetail> detaillist=new ArrayList<>();
	
	public void addSaleItem(SaleDetail s) {
		s.setSale(this);
		detaillist.add(s);
	}
	public int getSubTotal() {
		return	detaillist.stream().mapToInt(sd->sd.getSubQty()*sd.getItem().getPrice()).sum();
		
	}
	public int getTotalQty() {
		return detaillist.stream().mapToInt(sd->sd.getSubQty()).sum();
	}
	public double getTax() {
		return getSubTotal()*0.05;
	}
	public double getTotal() {
		return getSubTotal()+getTax();
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
	
	
	public LocalDate getSale_date() {
		return sale_date;
	}
	public void setSale_date(LocalDate sale_date) {
		this.sale_date = sale_date;
	}
	public List<SaleDetail> getDetaillist() {
		return detaillist;
	}
	public void setDetaillist(List<SaleDetail> detaillist) {
		this.detaillist = detaillist;
	}
	public List<SaleDetail> getDetailList() {
		return detaillist;
	}
	public void setDetailList(List<SaleDetail> detailList) {
		this.detaillist = detailList;
	}
}
