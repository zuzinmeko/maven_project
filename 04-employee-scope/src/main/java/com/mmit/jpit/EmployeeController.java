package com.mmit.jpit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/save")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if("/save".equals(path)) {
			
			//GET parameter
			String username=req.getParameter("name");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			String salary=req.getParameter("salary");
			
			//create object
			Employee emp=new Employee();
			emp.setEmail(email);
			emp.setLoginName(username);
			emp.setPhone(phone);
			emp.setSalary(salary);
			
			//create session
			HttpSession session=req.getSession(true);
			
			//get data from session scope
			List list=(ArrayList<Employee>)session.getAttribute("employeeList");
			if(list==null) 
				list=new ArrayList<Employee>();
			
			//add emp obj list to session
			list.add(emp);
			session.setAttribute("employeeList", list);
			
			//invoke other web resource to display data
			//getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
			resp.sendRedirect("display.jsp");
		}
	}
}
