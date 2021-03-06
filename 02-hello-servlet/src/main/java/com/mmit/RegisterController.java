package com.mmit;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns= {"/register","/user-info"})
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		if("/register".equals(path)) {
			String username=req.getParameter("name");
			String password=req.getParameter("pass");
			String email=req.getParameter("email");
			LocalDate dob=LocalDate.parse(req.getParameter("dob"));
			int age=Integer.parseInt(req.getParameter("age"));
			//String hobbies[]=req.getParameterValues("hobbies");
			//username="Hello, "+username.toUpperCase();
			req.setAttribute("username",username);
			getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
		}
		else if("/user-info".equals(path)) {
			resp.getWriter().print("<h1>"+req.getParameter("name")+"</h1>");
		}
	}
	
}
