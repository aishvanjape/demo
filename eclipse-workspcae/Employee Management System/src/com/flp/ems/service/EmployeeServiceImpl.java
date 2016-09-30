package com.flp.ems.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IEmployeeDao;
import com.flp.ems.domain.Employee;
import com.flp.ems.util.Validate;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDao dao_interface;
	
	public EmployeeServiceImpl() {
		
		dao_interface = new EmployeeDaoImplForList();
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
		if(receivedemployee == null)
		{
			return "Employee Not Found";
		}
		else
		{
			return ("Employee Found !!"+receivedemployee.toString());
		}
	}

	@Override
	public ArrayList<String> getAllEmployee() {
		ArrayList<String> stringlist = new ArrayList<String>();
		ArrayList<Employee> receivedlist;
		receivedlist = dao_interface.getAllEmployee();
		for(Employee employee:receivedlist){
			String temp;
			temp = "\nName :"+employee.getName()+"\nKin Id :"+employee.getKin_Id()+"\nEmail Id :"+employee.getEmail_Id()+"\nRole Id :"+employee.getRole_Id()+"\nProject Id :"+employee.getProject_Id()+"\nDepartment Id :"+employee.getDepartment_Id();
			stringlist.add(temp);
		}
		return stringlist;
	}

}