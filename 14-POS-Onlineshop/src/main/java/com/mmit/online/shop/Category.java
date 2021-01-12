package com.mmit.online.shop;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.mmit.online.shop.Item;
import static javax.persistence.CascadeType.REMOVE;

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
	@OneToMany(mappedBy = "category", cascade = REMOVE, orphanRemoval = true)
	private List<Item> itemList;
	public Category() {
		super();
	}
   
}
