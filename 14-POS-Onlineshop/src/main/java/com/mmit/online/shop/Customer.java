package com.mmit.online.shop;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customername;
	private String email;
	private String password;
	private String phone;
	@OneToMany(mappedBy = "customer")//many ဆံုးရင္ mappedBy
	private List<Orders> orderList;
	public Customer() {
		super();
	}
   
}
