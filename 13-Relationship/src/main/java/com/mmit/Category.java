package com.mmit;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name = "categoryId"), name = "item_category_tb", 
	inverseJoinColumns = @JoinColumn(name = "itemId"))
	private List<Item> items; //collection variable
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Category() {
		super();
	}
   
}
