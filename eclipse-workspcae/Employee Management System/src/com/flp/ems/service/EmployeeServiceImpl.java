package com.flp.ems.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import com.flp.ems.dao.EmployeeDaoImplForDB;
import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.domain.Employee;
import com.flp.ems.util.Validate;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDao dao_interface;
	
	public EmployeeServiceImpl() throws IOException {
		
		dao_interface = new EmployeeDaoImplForDB();
	}
	
	@Override
	public void AddEmployee(HashMap<String, String> hashobject) {
		
		String name, address;
		long phone_no,department_id,project_id,role_id;
		Date date_of_birth = null,date_of_joining = null;
		
		ArrayList<Employee> employeelist = new ArrayList<Employee>();
		
		name = hashobject.get("Name");
		address = hashobject.get("Address");
		phone_no = Long.parseLong(hashobject.get("Phone_No"));
		department_id = Long.parseLong(hashobject.get("Department_Id"));
		project_id = Long.parseLong(hashobject.get("Project_Id"));
		role_id = Long.parseLong(hashobject.get("Role_Id"));
	
		
		
		try {
			date_of_birth = Validate.validate_Date(hashobject.get("Date_Of_Birth"));
			date_of_joining = Validate.validate_Date(hashobject.get("Date_Of_Joining"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employeelist = dao_interface.getAllEmployee();
		HashMap<Employee,Object> employeelistmap = new HashMap<Employee,Object>();
		for(Employee emp:employeelist)
		{
			employeelistmap.put(emp, null);
		}
	
		
		Employee employee = new Employee(name, phone_no, date_of_birth, date_of_joining, address, department_id, project_id, role_id);
		
		if(employeelistmap.containsKey(employee))
		{
			//throw exception
		}
		else
		{
			dao_interface.AddEmployee(employee);
		}
		
		
	}

	@Override
	public String ModifyEmployee(HashMap<String, String> hashobject) {
		Employee receivedemployee;
		receivedemployee = dao_interface.SearchEmployee(hashobject);
		if(receivedemployee == null)
		{
		return "Employee Not Found!!Unable to modify";	
		}
		else{
			if(hashobject.get("Phone_No") != null) 
			{
				receivedemployee.setPhone_no(Long.parseLong(hashobject.get("Phone_No")));
			}
			if(hashobject.get("Date_Of_Birth") != null) 
			{
				try {
					receivedemployee.setDate_Of_Birth(Validate.validate_Date(hashobject.get("Date_Of_Birth")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(hashobject.get("Date_Of_Joining") != null) 
			{
				try {
					receivedemployee.setDate_Of_Joining(Validate.validate_Date(hashobject.get("Date_Of_Joining")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(hashobject.get("Address") != null) 
			{
				receivedemployee.setAddress(hashobject.get("Address"));
			}
			
			if(hashobject.get("Department_Id") != null) 
			{
				receivedemployee.setDepartment_Id(Long.parseLong(hashobject.get("Department_Id")));
			}
			if(hashobject.get("Project_Id") != null) 
			{
				receivedemployee.setProject_Id(Long.parseLong(hashobject.get("Project_Id")));
			}
			if(hashobject.get("Role_Id") != null) 
			{
				receivedemployee.setRole_Id(Long.parseLong(hashobject.get("Role_Id")));
			}
			
			
			
			
			if(dao_interface.ModifyEmployee(receivedemployee))
			{
				return "Employee Modified successfully";
			}
			else{
				return "Error in modifying";
			}
		}		
	}

	@Override
	public String RemoveEmployee(HashMap<String, String> hashobject) {
		Employee receivedemployee;
		receivedemployee = dao_interface.SearchEmployee(hashobject);
		if(receivedemployee == null)
		{
		return "Employee Not Found!!Unable to remove";	
		}
		else{
			if(dao_interface.RemoveEmployee(receivedemployee))
			{
				return "Employee Removed successfully";
			}
			else{
				return "Error in removing";
			}
		}
		
	}

	@Override
	public String SearchEmployee(HashMap<String, String> hashobject) {
		Employee receivedemployee;
		receivedemployee = dao_interface.SearchEmployee(hashobject);
		if(receivedemployee != null)
		{
			return ("Employee Found !!"+receivedemployee.toString());
		}
		else
		{
			return null;
		}
	}

	@Override
	public ArrayList<String> getAllEmployee() {
		ArrayList<String> stringlist = new ArrayList<String>();
		ArrayList<Employee> receivedlist;
		receivedlist = dao_interface.getAllEmployee();
		for(Employee employee:receivedlist){
			String temp;
			temp = "\nName :"+employee.getName()+"\nKin Id :"+employee.getKin_Id()+"\nEmail Id :"+employee.getEmail_Id()+"\nRole Id :"+employee.getRole_Id()+"\nProject Id :"+employee.getProject_Id()+"\nDepartment Id :"+employee.getDepartment_Id()+"\nPhone NO:"+employee.getPhone_no();
			stringlist.add(employee.toString());
		}
		return stringlist;
	}

}
