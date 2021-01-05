package com.mmit.entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mmit.service.CourseService;
import com.mmit.service.StudentService;
@WebServlet(urlPatterns = {"/add-student","/students","/remove-student","/edit-student"},loadOnStartup = 2)
@MultipartConfig
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory  emf;
	private StudentService service;
	
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
		service=new StudentService(emf.createEntityManager());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String path=req.getServletPath();
		String action=req.getServletPath();
		if("/add-student".equals(action)) {
			req.setAttribute("title", "add-student");
			getServletContext().getRequestDispatcher("/student-add.jsp").forward(req, resp);
		}else if("/students".equals(action)) {
			List<Student> list=service.findAll();
			req.setAttribute("studentlist", list);
			getServletContext().getRequestDispatcher("/student.jsp").forward(req, resp);
		
		}else if("/remove-student".equals(action)){
			//get parameter 
			String id=req.getParameter("studentId");
			//remove entity
			service.delete(Integer.parseInt(id));
			//redirect display page-invoke student list page
			resp.sendRedirect(req.getContextPath().concat("/students"));
		}else if("/edit-student".equals(action)) {
			//get parameter
			int id=Integer.parseInt(req.getParameter("id"));
			
			//retrieve data form db
				Student s=service.findById(id);
			
			//add course entity to request obj
			req.setAttribute("studentlist", s);
			
			//invoke other web page
			req.setAttribute("title", "addstudent");
			getServletContext().getRequestDispatcher("/student-add.jsp").forward(req, resp);
			
		}

		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
				String id=req.getParameter("studentid");
				String name=req.getParameter("sname");
				String email=req.getParameter("email");
				String year=req.getParameter("year");
				String age=req.getParameter("age");
				String address =req.getParameter("address");
				String dateofbirth=req.getParameter("date");
				Part imgPart=req.getPart("photo");
				
				String imgFileName=imgPart.getSubmittedFileName();//user.jpg
				//System.out.println("imgFileName "+imgFileName);
				
				String CurrentName=imgFileName.substring(0,imgFileName.lastIndexOf("."));
				//System.out.println("currentName :"+CurrentName);
				
				String newName=""+System.currentTimeMillis();//user12345678
				//System.out.println("newName "+newName);
				
				imgFileName=imgFileName.replace(CurrentName, newName);//user12345678.jpg
				//System.out.println("After upload img file "+imgFileName);
			
				//create object
				Student student=(id !=null && !id.isEmpty()? service.findById(Integer.parseInt(id)):new Student());
				student.setName(name);
				student.setEmail(email);
				student.setAge(Integer.parseInt(age));
				student.setYear(year);
				student.setAddress(address);
				student.setDateOfBirth(LocalDate.parse(dateofbirth));
				student.setProfile(imgFileName);
				
				//insert student entity obj ot db
				service.saveStuden(student);
				
			
				
				String rootPath=getServletContext().getRealPath("");
				String dirPath=rootPath+File.separator+"imgUploads";
				File rootDir=new File(dirPath);
				if(!rootDir.exists())
					rootDir.mkdirs();
				
				imgPart.write(rootDir+File.separator+imgFileName);
					
				//invoke other web page(for display)
				//System.out.println("path :"+req.getContextPath());
				resp.sendRedirect(req.getContextPath().concat("/students"));
				//getServletContext().getRequestDispatcher("/student.jsp").forward(req, resp);
				
	
	}

}
