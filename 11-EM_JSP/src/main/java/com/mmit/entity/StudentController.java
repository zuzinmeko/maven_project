package com.mmit.entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@WebServlet(urlPatterns = {"/add-student","/students"},loadOnStartup = 2)
@MultipartConfig
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		String title="students";
		String page="/student.jsp";
		
		if("/add-student".equals(path)) {
			title="addstudent";
			page="/student-add.jsp";
		}
		req.setAttribute("title", title);
		getServletContext().getRequestDispatcher(page).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get parameter data
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
				Student student=new Student();
				student.setName(name);
				student.setEmail(email);
				student.setAge(Integer.parseInt(age));
				student.setYear(year);
				student.setAddress(address);
				student.setDateOfBirth(LocalDate.parse(dateofbirth));
				student.setProfile(imgFileName);
				
				
				//get session object
				HttpSession session=req.getSession(true);
				List<Student> list=(ArrayList<Student>)session.getAttribute("studentlist");
				if(list==null)
					list=new ArrayList<Student>();
				//add new course object to session object
				list.add(student);
				//add list object to session object
				session.setAttribute("studentlist", list);
				
				String rootPath=getServletContext().getRealPath("");
				String dirPath=rootPath+File.separator+"imgUploads";
				File rootDir=new File(dirPath);
				if(!rootDir.exists())
					rootDir.mkdirs();
				
				imgPart.write(rootDir+File.separator+imgFileName);
					
				//invoke other web page(for display)
				//System.out.println("path :"+req.getContextPath());
				//resp.sendRedirect(req.getContextPath());
				//getServletContext().getRequestDispatcher("/student.jsp").forward(req, resp);
				resp.sendRedirect("student.jsp");
	
	}

}
