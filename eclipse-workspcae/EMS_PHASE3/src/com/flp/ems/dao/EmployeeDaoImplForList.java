package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao{
	
	ArrayList<Employee> employeelist = new ArrayList<Employee>();

	@Override
	public void AddEmployee(Employee e) {
		
		employeelist.add(e);
	}

	@Override
	public boolean ModifyEmployee(Employee employee) {
		employeelist.set(employeelist.indexOf(employee), employee);
		return true;
	}

	@Override
	public boolean RemoveEmployee(Employee employee) {
		try{
			employeelist.remove(employee);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public Employee SearchEmployee(HashMap<String, String> hashfield) {
		Employee receivedemployee=null;
//		String key=null,value=null;
		
		String key_name,key_kin,key_email;
		
		key_name = hashfield.get("Name");
		key_kin = hashfield.get("Kin_Id");
		key_email = hashfield.get("Email_Id");
		
		/*
		for(Entry<String, String>  entry: hashfield.entrySet())
		{
			key = entry.getKey();
			value = entry.getValue();
			
		}
		*/
		
		for(Employee emp:employeelist)
		{
			
			if(key_name.equals("NA") && key_kin.equals(emp.getKin_Id()) && key_email.equals(emp.getEmail_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_kin.equals("NA") && key_name.equals(emp.getName()) && key_email.equals(emp.getEmail_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_email.equals("NA") && key_name.equals(emp.getName()) && key_kin.equals(emp.getKin_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_name.equals("NA") && key_kin.equals("NA") && key_email.equals(emp.getEmail_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_kin.equals("NA") && key_email.equals("NA") && key_name.equals(emp.getName()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_email.equals("NA") && key_name.equals("NA") && key_kin.equals(emp.getKin_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			else if(key_email.equals(emp.getEmail_Id()) && key_name.equals(emp.getName()) && key_kin.equals(emp.getKin_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
		}
		return receivedemployee;
		
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		
		return (ArrayList<Employee>)employeelist.clone();
		
	}

}
