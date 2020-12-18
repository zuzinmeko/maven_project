package com.mmit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/hello")
@WebServlet(urlPatterns= {"/login"})
public class HelloServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		System.out.println("This is init method");
		System.out.println("------------------");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("This is doPost method");
		System.out.println("------------------");
		PrintWriter writer=resp.getWriter();
		writer.write("<h1>zuzinmeko</h1>");
	}
}
