package com.mmit.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/register")
@MultipartConfig
public class UserController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get request data
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		Part imgPart=req.getPart("photo");
		
		String imgFileName=imgPart.getSubmittedFileName();//user.jpg
		//System.out.println("imgFileName "+imgFileName);
		
		String CurrentName=imgFileName.substring(0,imgFileName.lastIndexOf("."));
		//System.out.println("currentName :"+CurrentName);
		
		String newName=""+System.currentTimeMillis();//user12345678
		//System.out.println("newName "+newName);
		
		imgFileName=imgFileName.replace(CurrentName, newName);//user12345678.jpg
		//System.out.println("After upload img file "+imgFileName);
		
		//create user name
		Users u=new Users();
		u.setEmail(email);
		u.setName(name);
		u.setProfile(imgFileName);
		
		//add user request to request scope
		req.setAttribute("userinfo", u);
		
		//save client upload file in sever
		String rootPath=getServletContext().getRealPath("");
		String dirPath=rootPath+File.separator+"imgUploads";
		File rootDir=new File(dirPath);
		if(!rootDir.exists())
			rootDir.mkdirs();
		
		imgPart.write(rootDir+File.separator+imgFileName);
		//System.out.println("path "+rootPath);
		//System.out.println("dir "+rootDir);
		
		//invoke other web resource to display data
		
		getServletContext().getRequestDispatcher("/display.jsp").forward(req, resp);
		
	
		
	}

}
