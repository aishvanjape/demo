package com.flp.ems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;


public class ControllerServlet extends HttpServlet{
	
	private static final String ACTION = "action";
	private static final String ACTION_ADD = "ADD";
	private static final String ACTION_MODIFY = "MODIFY";
	private static final String ACTION_REMOVE = "REMOVE";
	private static final String ACTION_VIEW = "VIEW";
	private static final String ACTION_SEARCH = "SEARCH";
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processrequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processrequest(req, resp);
	}
	
	
	protected void processrequest(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		IEmployeeService employeeservice = new EmployeeServiceImpl();
		
		String actionName = req.getParameter( ACTION );
		String destinationPage = null;
		
		if(ACTION_ADD.equals(actionName))
		{
			String name,phone_no,date_of_birth,date_of_joining;
			String address,department_id,project_id,role_id;
			HashMap<String, String> hashobject = new HashMap<String,String>();
			destinationPage = "display.jsp";
	
			name = req.getParameter("name");
			hashobject.put("Name", name);
			phone_no = req.getParameter("number");
			hashobject.put("Phone_No", phone_no);
			date_of_birth = req.getParameter("dateOfBirth");
			hashobject.put("Date_Of_Birth", date_of_birth);
			date_of_joining = req.getParameter("dateOfJoining");
			hashobject.put("Date_Of_Joining", date_of_joining);
			address = req.getParameter("address");
			hashobject.put("Address", address);
			department_id = req.getParameter("dept");
			hashobject.put("Department_Id", department_id);
			project_id = req.getParameter("project");
			hashobject.put("Project_Id", project_id);
			role_id = req.getParameter("role");
			hashobject.put("Role_Id", role_id);
			
			
			req.setAttribute("message", employeeservice.AddEmployee(hashobject));
			RequestDispatcher dispatcher = req.getRequestDispatcher(destinationPage);
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(ACTION_VIEW.equals(actionName))
		{
			destinationPage = "display.jsp";
			ArrayList<String[]> receivedlist;
			receivedlist = employeeservice.getAllEmployee();
			
			req.setAttribute("message", "EMPLOYEES");
			req.setAttribute("employees", receivedlist);
			RequestDispatcher dispatcher = req.getRequestDispatcher(destinationPage);
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ACTION_SEARCH.equals(actionName))
		{
			destinationPage = "display.jsp";
			HashMap<String, String> hashobject = new HashMap<String,String>();
			String name,kin_id,email_id,receivedstring[];
			ArrayList<String[]> receivedlist =  new ArrayList<String[]>();
			hashobject.put("Name", "NA");
			hashobject.put("Kin_Id", "NA");
			hashobject.put("Email_Id", "NA");
			
			name = req.getParameter("name");
			kin_id = req.getParameter("kinId");
			email_id = req.getParameter("emailId");
			if(!name.isEmpty())
			{
				hashobject.put("Name", name);
			}
			if(!kin_id.isEmpty())
			{
				hashobject.put("Kin_Id", kin_id);
			}
			if(!email_id.isEmpty())
			{
				hashobject.put("Email_Id", email_id);
			}
			
			receivedstring = employeeservice.SearchEmployee(hashobject);
			if(receivedstring == null)
			{
				req.setAttribute("message", "Employee Not Found");
			}
			else 
			{
				receivedlist.add(receivedstring);
				req.setAttribute("message", "Employee Found!!");
				req.setAttribute("employees", receivedlist);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher(destinationPage);
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
