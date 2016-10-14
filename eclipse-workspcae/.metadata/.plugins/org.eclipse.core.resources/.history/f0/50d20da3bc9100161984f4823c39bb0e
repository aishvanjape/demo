package com.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/testsession")
public class SessionServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//System.out.println(session.getId());
		ServletContext
		String encodeurl = resp.encodeURL("getDate");
		
		resp.sendRedirect(encodeurl);
		
		//req.getRequestDispatcher("getDate").include(req, resp);
		
	}
	
}
