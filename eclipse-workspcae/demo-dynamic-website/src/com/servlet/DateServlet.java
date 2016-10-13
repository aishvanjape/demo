package com.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Local;

@WebServlet("/getDate")
public class DateServlet extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		
//		HttpSession session = req.getSession();
//		System.out.println(session.getId());

		System.out.println(getServletContext());
		System.out.println(getServletConfig());
		(resp.getWriter()).println(new Date());
		(resp.getWriter()).println(Thread.currentThread().getName());
	}

}
