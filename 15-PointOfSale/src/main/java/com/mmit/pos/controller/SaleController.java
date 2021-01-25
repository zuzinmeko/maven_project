package com.mmit.pos.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.mmit.pos.model.entity.Sale;
import com.mmit.pos.model.entity.SaleDetail;
import com.mmit.pos.model.entity.SaleDetailJSON;
import com.mmit.pos.model.service.SaleService;


@WebServlet(urlPatterns = {"/sale","/search","/sale-detail"},loadOnStartup = 1)
public class SaleController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private SaleService saleService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("POS");
			getServletContext().setAttribute("emf", emf);
		}
		saleService = new SaleService(emf.createEntityManager());
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		if ("/sale-detail".equals(path)) {
			getSaleDetail(req,resp);
		}else if ("/sale".equals(path) || "/search".equals(path)) {
			
			String from = req.getParameter("from");
			String to = req.getParameter("to");
			List<Sale> list = saleService.search(from,to);
				
			req.setAttribute("sales", list);
			getServletContext().getRequestDispatcher("/sale.jsp").forward(req, resp);
		}
	}

	private void getSaleDetail(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json;charset=UTF-8");

		
		String saleId = req.getParameter("id");
		System.out.println("-------------------------------");
		System.out.println("Sale id using ajax = "+saleId);
		
		Sale sale = saleService.findById(Integer.parseInt(saleId));
		System.out.println("-------------------------------");
		System.out.println("Saledetail id using ajax = "+sale.getDetailList().get(0).getItem().getName());
		
		List<SaleDetailJSON> details=new ArrayList<>();
		for(SaleDetail sd:sale.getDetailList()) {
			SaleDetailJSON s=new SaleDetailJSON(sd.getItem(),sd.getSubQty());
			details.add(s);
		}
		
//		var converter = new JspWriter(); 
//		String output = converter.convertToJson(details);
//		System.out.println("-------------------------------");
//		System.out.println("Sale Detail = "+ output);
//		resp.getWriter().print(output);
		
	}

}
