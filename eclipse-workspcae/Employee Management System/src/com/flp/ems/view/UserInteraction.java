package com.flp.ems.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;

public class UserInteraction {

	IEmployeeService employeeservice;
	public UserInteraction() {
		employeeservice = new EmployeeServiceImpl();
	}
	
	void AddEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id,email_id,phone_no,date_of_birth,date_of_joining;
		String address,department_id,project_id,role_id;
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter Employee Details");
		System.out.println("Name : ");
		name = scanner.next();
		hashobject.put("Name", name);
		System.out.println("Phone No : ");
		phone_no = scanner.next();
		hashobject.put("Phone_No", phone_no);
		System.out.println("Date Of Birth : ");
		date_of_birth = scanner.next();
		hashobject.put("Date_Of_Birth", date_of_birth);
		System.out.println("Date Of Joining : ");
		date_of_joining = scanner.next();
		hashobject.put("Date_Of_Joining", date_of_joining);
		System.out.println("Address : ");
		address = scanner.next();
		hashobject.put("Address", address);
		System.out.println("Department Id : ");
		department_id = scanner.next();
		hashobject.put("Department_Id", department_id);
		System.out.println("Project Id : ");
		project_id = scanner.next();
		hashobject.put("Project_Id", project_id);
		System.out.println("Role Id : ");
		role_id = scanner.next();
		hashobject.put("Role_Id", role_id);
		
		
		employeeservice.AddEmployee(hashobject);
	}
	
	void ModifyEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id,email_id,phone_no,date_of_birth,date_of_joining;
		String address,department_id,project_id,role_id;
		HashMap<String, String> hashkin = new HashMap<String,String>();
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter KIN_ID for employee detail modification");
		kin_id = scanner.next();
		hashkin.put("Kin_Id", kin_id);
		System.out.println(employeeservice.SearchEmployee(hashkin));
		
		
		System.out.println("\nEnter New Employee Details");
		System.out.println(" Name : ");
		name = scanner.next();
		hashobject.put("Name", name);
		System.out.println("Phone No : ");
		phone_no = scanner.next();
		hashobject.put("Phone_No", phone_no);
		System.out.println("Date Of Birth : ");
		date_of_birth = scanner.next();
		hashobject.put("Date_Of_Birth", date_of_birth);
		System.out.println("Date Of Joining : ");
		date_of_joining = scanner.next();
		hashobject.put("Date_Of_Joining", date_of_joining);
		System.out.println("Address : ");
		address = scanner.next();
		hashobject.put("Address", address);
		System.out.println("Department Id : ");
		department_id = scanner.next();
		hashobject.put("Department_Id", department_id);
		System.out.println("Project Id : ");
		project_id = scanner.next();
		hashobject.put("Project_Id", project_id);
		System.out.println("Role Id : ");
		role_id = scanner.next();
		hashobject.put("Role_Id", role_id);
		
		
		employeeservice.ModifyEmployee(hashobject);
		
		
	}
	
	void RemoveEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id;
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter field used for removing");
		System.out.println("\n1.Name\n2.Kin_Id");
		int ch = scanner.nextInt();
		
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter Name");
				name = scanner.next();
				hashobject.put("Name", name);
				//employeeservice.SearchEmployee(hashobject);
				System.out.println(employeeservice.RemoveEmployee(hashobject));
				break;
			case 2:
				System.out.println("\nEnter Kin_Id");
				kin_id = scanner.next();
				hashobject.put("Kin_Id", kin_id);
				//employeeservice.SearchEmployee(hashobject);
				System.out.println(employeeservice.RemoveEmployee(hashobject));
				break;
			default:
				break;
		}
		
	}
	
	void SearchEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id,email_id;
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter field for searching");
		System.out.println("\n1.Name\n2.Kin_Id\n3.Email_Id");
		int ch = scanner.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter Name");
				name = scanner.next();
				hashobject.put("Name", name);
				System.out.println(employeeservice.SearchEmployee(hashobject));
				break;
			case 2:
				System.out.println("\nEnter Kin_Id");
				kin_id = scanner.next();
				hashobject.put("Kin_Id", kin_id);
				System.out.println(employeeservice.SearchEmployee(hashobject));
				break;
			case 3:
				System.out.println("\nEnter Email_Id");
				email_id = scanner.next();
				hashobject.put("Email_Id", email_id);
				System.out.println(employeeservice.SearchEmployee(hashobject));
				break;
			default:
				break;
		}
		
	}
	
	void getAllEmployee()
	{
		ArrayList<String> receivedlist;
		receivedlist = employeeservice.getAllEmployee();
		
		for(String displaystring:receivedlist)
		{
			System.out.println(displaystring);
		}
		
	}
	
}