package com.mmit.entity;

import java.io.IOException;
import java.time.LocalDate;
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
import javax.servlet.http.HttpSession;

import com.mmit.service.CourseService;
@WebServlet({"/add-course","/courses"})
public class CourseController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;
	
	private CourseService service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		Object object=getServletContext().getAttribute("entitymanagerfactory");
		if(object==null) {
			emf=Persistence.createEntityManagerFactory("jpa11");
			getServletContext().setAttribute("entitymanagerfactory", emf);
		}else {
			emf=(EntityManagerFactory) object;
		}
		service=new CourseService(emf.createEntityManager());
	}
	@Override
	public void destroy() {
		if(emf!=null && emf.isOpen())
			emf.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getServletPath();
		if("/add-course".equals(action)) {
			req.setAttribute("title", "addcourse");
			getServletContext().getRequestDispatcher("/course-add.jsp").forward(req, resp);
		}else if("/courses".equals(action)) {
			//get course list from database
			List<Course> list=service.findAll();
			
			//add list to request object
			req.setAttribute("courselist", list);
			//invoke index.jsp to display data
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	
	} 
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
		String name=req.getParameter("courseName");
		String price=req.getParameter("price");
		String level=req.getParameter("level");
		String duration=req.getParameter("duration");
		String date=req.getParameter("date");
	
		//create object
		Course course=new Course();
		course.setDuration(Integer.parseInt(duration));
		course.setLevel(level);
		course.setName(name);
		course.setPrice(Integer.parseInt(price));
		course.setStartDate(LocalDate.parse(date));
		
		//insert course entity object to database
		service.saveCourse(course);
		
		
		resp.sendRedirect(req.getContextPath().concat("/courses"));
	}

}
