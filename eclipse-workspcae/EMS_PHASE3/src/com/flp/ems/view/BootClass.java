package com.flp.ems.view;

import java.util.Scanner;

public class BootClass {

	public static void main(String[] args) {
		
		menuSelection();
		
	}
	
	static void menuSelection()
	{
		Scanner scanner = new Scanner(System.in);
		UserInteraction userinteraction = new UserInteraction();
		int ch;
		do
		{
			System.out.println("\n1.Add Employee\n2.Modify Employee\n3.Remove Employee\n4.Search Employee\n5.Display All Employees\n6.Exit");
			ch = scanner.nextInt();
		
			switch(ch)
			{
				case 1:
					userinteraction.AddEmployee();
					break;
				case 2:
					userinteraction.ModifyEmployee();
					break;
				case 3:
					userinteraction.RemoveEmployee();
					break;
				case 4:
					userinteraction.SearchEmployee();
					break;
				case 5:
					userinteraction.getAllEmployee();
					break;
				default:
					break;
			
			}
		}while(ch != 6);
		
		
	}
	
}
