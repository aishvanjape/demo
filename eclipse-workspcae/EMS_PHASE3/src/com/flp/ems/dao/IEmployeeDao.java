package com.flp.ems.dao;
import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Employee;
public interface IEmployeeDao {
	
	
	void AddEmployee(Employee newemployee);
	boolean ModifyEmployee(Employee employee);
	boolean RemoveEmployee(Employee employee);	
	Employee SearchEmployee(HashMap<String, String> hashfield);
	ArrayList getAllEmployee();

}
