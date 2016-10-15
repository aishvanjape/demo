package com.flp.ems.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.service.IEmployeeService;

public class UserInteraction {

	IEmployeeService employeeservice;
	public UserInteraction()  {
		try {
			employeeservice = new EmployeeServiceImpl();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String receivedstring;
		int choice,ch,option;
		
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter field used for searching and modifying");
		System.out.println("\n1.Name\n2.Kin_Id");
		ch = scanner.nextInt();
		
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter Name");
				name = scanner.next();
				hashobject.put("Name", name);
				hashobject.put("Kin_Id","NA");
				hashobject.put("Email_Id","NA");
				break;
			case 2:
				System.out.println("\nEnter Kin_Id");
				kin_id = scanner.next();
				hashobject.put("Name", "NA");
				hashobject.put("Kin_Id",kin_id);
				hashobject.put("Email_Id","NA");
				break;
			default:
				break;
		}		
			if(ch == 1 || ch == 2)
			{
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("Employee Not Found");
				}
				else
				{
					System.out.println(receivedstring);
					System.out.println("Do you want to modify this employee?(1/0)");
					choice = scanner.nextInt();
					if(choice == 1)
					{
						System.out.println("\nEnter field to be modified");
						System.out.println("\n1.Phone No\n2.Date Of Birth\n3.Date Of Joining");
						System.out.println("4.Name\n5.Address\n6.Department ID\n7.Project ID\n8.Role ID");
						option = scanner.nextInt();
						switch(option)
						{
						case 1:
							System.out.println("Phone No : ");
							phone_no = scanner.next();
							hashobject.put("Phone_No", phone_no);
//							hashobject.put("Date_Of_Birth", "NA");
//							hashobject.put("Date_Of_Joining", "NA");
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 2:
							System.out.println("Date Of Birth : ");
							date_of_birth = scanner.next();
							hashobject.put("Date_Of_Birth", date_of_birth);
//							hashobject.put("Phone_No", "NA");
//							hashobject.put("Date_Of_Joining", "NA");
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 3:
							System.out.println("Date Of Joining : ");
							date_of_joining = scanner.next();
							hashobject.put("Date_Of_Joining", date_of_joining);
//							hashobject.put("Phone_No", "NA");
//							hashobject.put("Date_Of_Birth", "NA");
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 4:
							System.out.println("Name : ");
							name = scanner.next();
							hashobject.put("Name", name);
							hashobject.put("Phone_No", "NA");
							hashobject.put("Date_Of_Birth", "NA");
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 5:
							System.out.println("Address : ");
							address = scanner.next();
							hashobject.put("Address", address);
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 6:
							System.out.println("Department Id : ");
							department_id = scanner.next();
							hashobject.put("Department_Id", department_id);
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 7:
							System.out.println("Project Id : ");
							project_id = scanner.next();
							hashobject.put("Project_Id", project_id);
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						case 8:
							System.out.println("Role Id : ");
							role_id = scanner.next();
							hashobject.put("Role_Id", role_id);
							System.out.println(employeeservice.ModifyEmployee(hashobject));
							break;
						default:
							break;
						}			
					}
				}
			}
	}
	
	void RemoveEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id,receivedstring;
		int choice,ch;
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter field used for searching and removing");
		System.out.println("\n1.Name\n2.Kin_Id");
		ch = scanner.nextInt();
		
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter Name");
				name = scanner.next();
				hashobject.put("Name", name);
				hashobject.put("Kin_Id","NA");
				hashobject.put("Email_Id","NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("Employee Not Found");
				}
				else
				{
					System.out.println(receivedstring);
					System.out.println("Do you want to remove this employee?(1/0)");
					choice = scanner.nextInt();
					if(choice == 1)
					{
						System.out.println(employeeservice.RemoveEmployee(hashobject));
					}
				}
				break;
			case 2:
				System.out.println("\nEnter Kin_Id");
				kin_id = scanner.next();
				hashobject.put("Kin_Id", kin_id);
				hashobject.put("Name", "NA");
				hashobject.put("Email_Id","NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("Employee Not Found");
				}
				else
				{
					System.out.println(receivedstring);
					System.out.println("Do you want to remove this employee?(1/0)");
					choice = scanner.nextInt();
					if(choice == 1)
					{
						System.out.println(employeeservice.RemoveEmployee(hashobject));
					}
				}
				break;
			default:
				break;
		}
		
	}
	
	void SearchEmployee()
	{
		Scanner scanner = new Scanner(System.in);
		String name,kin_id,email_id,receivedstring;
		HashMap<String, String> hashobject = new HashMap<String,String>();
		
		System.out.println("\nEnter field for searching");
		System.out.println("\n1.Name\n2.Kin_Id\n3.Email_Id\n4.Name & Kin_Id\n5.Kin_ID & Email_Id");
		System.out.println("6.Name & Email_Id\n7.Name,Kin_Id,Email_Id");
		int ch = scanner.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("\nEnter Name");
				name = scanner.next();
				hashobject.put("Name", name);
				hashobject.put("Kin_Id", "NA");
				hashobject.put("Email_Id", "NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 2:
				System.out.println("\nEnter Kin_Id");
				kin_id = scanner.next();
				hashobject.put("Kin_Id", kin_id);
				hashobject.put("Name", "NA");
				hashobject.put("Email_Id", "NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 3:
				System.out.println("\nEnter Email_Id");
				email_id = scanner.next();
				hashobject.put("Email_Id", email_id);
				hashobject.put("Kin_Id", "NA");
				hashobject.put("Name", "NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 4:
				System.out.println("\nEnter Name");
				name = scanner.next();
				System.out.println("Enter Kin_id");
				kin_id = scanner.next();
				hashobject.put("Email_Id", "NA");
				hashobject.put("Kin_Id", kin_id);
				hashobject.put("Name", name);
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 5:
				System.out.println("Enter Kin_id");
				kin_id = scanner.next();
				System.out.println("\nEnter Email_id");
				email_id = scanner.next();
				hashobject.put("Email_Id", email_id);
				hashobject.put("Kin_Id", kin_id);
				hashobject.put("Name", "NA");
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 6:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("\nEnter Email_id");
				email_id = scanner.next();
				hashobject.put("Email_Id", email_id);
				hashobject.put("Kin_Id", "NA");
				hashobject.put("Name", name);
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
				break;
			case 7:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Kin_id");
				kin_id = scanner.next();
				System.out.println("\nEnter Email_id");
				email_id = scanner.next();
				hashobject.put("Email_Id", email_id);
				hashobject.put("Kin_Id", kin_id);
				hashobject.put("Name", name);
				receivedstring = employeeservice.SearchEmployee(hashobject);
				if(receivedstring == null)
				{
					System.out.println("\nEmployee Not Found");
				}
				else System.out.println(receivedstring);
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
