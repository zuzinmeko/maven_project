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
@NamedQuery(name="CategoryGetAll",query="SELECT c FROM Category c ")
@NamedQuery(name="Category.findByName",query="SELECT c FROM Category c WHERE c.name=:catName")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "category", cascade = REMOVE, orphanRemoval = true)
	private List<Item> itemList;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


	public Category() {
		super();
	}
   
}
