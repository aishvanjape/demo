package com.seed;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	TODO:1 Make DisplayCartDetailsServlet as a HttpServlet
@WebServlet("/displayDetails")
public class DisplayCartDetailsServlet extends HttpServlet{

//	TODO:2 	Provide call-back method (called by web container) for HTTP request made using HTTP GET method
//	TODO:3	This method should read products selected by web-client from bookCatelogue.html and 
//					display them in tabular format as html response to the web client.	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<table>");
		Enumeration<String> list = req.getParameterNames();
		while(list.hasMoreElements())
		{
			String[] arr;
			out.println("<tr>");
			String p = list.nextElement();
			if(p.equals("bookName"))
			{
				arr = req.getParameterValues(p);
				for(String a:arr)
				{
					out.println("<td>");
					out.println(a);
					out.println("</td>");
				}
				out.println("</tr>");
			}
		}
		
		out.println("</table>");
		out.println("</html></body>");
		
	}







}









