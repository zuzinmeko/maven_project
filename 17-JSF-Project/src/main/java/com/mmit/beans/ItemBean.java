package com.mmit.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ItemBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Item item;
	
	private List<Item> itemlist;
	
	@PostConstruct
	private void init() {
		item=new Item();
		itemlist=new ArrayList<>();
	}
	public void save() {
		itemlist.add(item);
		System.out.println("item :"+item.getName());
		item=new Item();
		//return "index?faces-redirect=true";
	}
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	
}
