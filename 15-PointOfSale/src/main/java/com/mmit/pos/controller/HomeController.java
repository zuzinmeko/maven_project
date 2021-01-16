package com.mmit.pos.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
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
@WebServlet(urlPatterns = {"/home"},loadOnStartup = 1)
public class HomeController extends HttpServlet {
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
		itemservice=new ItemService(emf.createEntityManager() );
		
		//get category list from db
		List<Category> list=service.findAll();
		getServletContext().setAttribute("categories", list);
	}
	@Override
	public void destroy() {
		EntityManagerFactory emf=(EntityManagerFactory) getServletContext().getAttribute("emf");
		if(emf!=null && emf.isOpen())
			emf.close();
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Item> list=itemservice.findAll();
		req.setAttribute("itemlist", list);
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
	}

}
