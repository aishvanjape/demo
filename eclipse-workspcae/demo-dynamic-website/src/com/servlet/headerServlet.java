package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showheaders")
public class headerServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		
		Enumeration<String> enumeration =req.getParameterNames();
		
		System.out.println(req.getQueryString());
		
		PrintWriter out= resp.getWriter();
		out.println("<html><body>");
		
		out.println("<table>");
		
		while(enumeration.hasMoreElements())
		{
			String name = enumeration.nextElement();
			String value = req.getHeader(name);
			String[] names = req.getParameterValues(name);
			System.out.println(names[0]);
			System.out.println(names[1]);
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			
			out.println("</tr>");
		}
		out.println("</body></html>");
	}
}
