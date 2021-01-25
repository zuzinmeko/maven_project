package com.mmit.pos.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.mmit.pos.model.entity.Sale;
import com.mmit.pos.model.entity.SaleDetail;
import com.mmit.pos.model.service.CategoryService;
import com.mmit.pos.model.service.ItemService;
import com.mmit.pos.model.service.SaleService;
@WebServlet(urlPatterns = {"/home","/add-to-cart","/cart-action"},loadOnStartup = 1)
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service;
	private ItemService itemservice;
	private SaleService saleservice;
	
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
		saleservice=new SaleService(emf.createEntityManager());
		
		
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
		String action=req.getServletPath();
		if("/add-to-cart".equals(action)) {
			addToCart(req);
			
		}

		getAllItems(req);
		getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
	}
	private void getAllItems(HttpServletRequest req) {

		List<Item> list=itemservice.findAll();
		req.setAttribute("itemlist", list);
		
	}
	private void addToCart(HttpServletRequest req) {
		//get current item added to cart
		String itemid=req.getParameter("id");
		int currentitemId=Integer.parseInt(itemid);
		
		//get cart info from session
		HttpSession session=req.getSession(true);
		Sale sale=(Sale) session.getAttribute("cart");
		if(sale==null)
			sale=new Sale();
		
		//verify current item is new or original?
		List<SaleDetail> saleitemList=sale.getDetaillist();
		boolean already_exist=false;
		
		for(SaleDetail sd: saleitemList) {
			if(sd.getItem().getId() == currentitemId) {
				sd.setSubQty(sd.getSubQty()+1);
				already_exist=true;
				break;
			}
		}
		//new sale item
		if(!already_exist) {
			Item item=itemservice.findById(currentitemId);
			SaleDetail newsaleitem=new SaleDetail();
			
			newsaleitem.setItem(item);
			newsaleitem.setSubQty(1);
			sale.addSaleItem(newsaleitem);
			}
		session.setAttribute("cart", sale);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("btnAction");
		HttpSession session=req.getSession(true);
		if("Paid".equals(action)) {
			//paid click=> save to db
			Sale sale=(Sale) session.getAttribute("cart");
			if(sale !=null && !sale.getDetaillist().isEmpty()) {
				saleservice.save(sale);
			}
			
		session.removeAttribute("cart");
		resp.sendRedirect(req.getContextPath().concat("/home"));
			
	}

}
}
