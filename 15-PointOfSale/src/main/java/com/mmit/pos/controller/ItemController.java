package com.mmit.pos.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mmit.pos.model.entity.Category;
import com.mmit.pos.model.entity.Item;
import com.mmit.pos.model.service.CategoryService;
import com.mmit.pos.model.service.ItemService;
@WebServlet (urlPatterns = {"/items","/item-add","/item-save","/item-edit"},loadOnStartup = 1)
public class ItemController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private CategoryService service;
	private ItemService itemservice;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("POS");
			getServletContext().setAttribute("emf", emf);
		}
		service=new CategoryService(emf.createEntityManager());
		itemservice=new ItemService(emf.createEntityManager());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action =req.getServletPath();
		if("/items".equals(action)) {
			//retrieve item list from db
			List<Item> list=itemservice.findAll();
			//add list to req obj
			req.setAttribute("itemlist", list);
			
			//invoke other resources to display
			getServletContext().getRequestDispatcher("/items.jsp").forward(req, resp);
		}
		else if("/item-add".equals(action) || "/item-edit".equals(action)) {
			String itemid=req.getParameter("id");
			Item i=(itemid !=null && !itemid.isEmpty()) ? itemservice.findById(Integer.parseInt(itemid)) :new Item();
			req.setAttribute("item", i);
			
			getServletContext().getRequestDispatcher("/item-add.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String expire=req.getParameter("expire");
		String catId=req.getParameter("category");
		String itemid=req.getParameter("itemid");
		//create item object
		Item item=(itemid.equals("0") ? new Item() :itemservice.findById(Integer.parseInt(itemid)));
		item.setName(name);
		item.setPrice(Integer.parseInt(price));
		item.setExpiredate(expire!=null ? LocalDate.parse(expire) :null);
		item.setCategory(service.findById(Integer.parseInt(catId)));
		
		//save it to db
		itemservice.save(item);
		
		
		//invoke other resources to display
		resp.sendRedirect(req.getContextPath().concat("/items"));
		
	}
}
