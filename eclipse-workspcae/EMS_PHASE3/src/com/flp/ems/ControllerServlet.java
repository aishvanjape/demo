package com.flp.ems;

import java.io.IOException;
import java.util.HashMap;

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
		IEmployeeService employeeservice=null;
		try {
			employeeservice = new EmployeeServiceImpl();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String actionName = req.getParameter( ACTION );
		String destinationPage = null;
		
		if(ACTION_ADD.equals(actionName))
		{
			String name,kin_id,email_id,phone_no,date_of_birth,date_of_joining;
			String address,department_id,project_id,role_id;
			HashMap<String, String> hashobject = new HashMap<String,String>();
			
	
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
			
			
			employeeservice.AddEmployee(hashobject);
		}
		
		
	}
	
	
}
