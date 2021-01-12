package com.mmit;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Item
 *
 */
@Entity
@Table(name="items")
public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="item_name")
	private String name;
	private int price;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "catId")
	private Category category;//single object သည္ =>OnetoOne and ManytoOne ပဲရပါတယ္။
							//collection list သည္ => OnetoMany and ManytoMany ပဲရပါတယ္။
	
	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Item() {
		super();
	}
   
}
