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
		String key=null,value=null;
		int index;
		
		for(Entry<String, String>  entry: hashfield.entrySet())
		{
			key = entry.getKey();
			value = entry.getValue();
		}
		
		for(Employee emp:employeelist)
		{
			if(key.equals("Name") && value.equals(emp.getName()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			if(key.equals("Kin_Id") && value.equals(emp.getKin_Id()))
			{
				receivedemployee = (Employee)emp.clone();
			}
			if(key.equals("Email_Id") && value.equals(emp.getEmail_Id()))
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
