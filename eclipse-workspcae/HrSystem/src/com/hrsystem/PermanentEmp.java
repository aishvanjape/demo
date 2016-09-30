package com.hrsystem;

public class PermanentEmp extends Employee {

	static int pe_count=0; 
	public PermanentEmp(String first_name, String last_name, int salary, String grade, String join) {
		super(first_name, last_name, salary, grade, join);
		pe_count++;
	}

	public void withdraw_salary()
	{
		System.out.println("Salary withdrawn for Permanent Employee: "+this.salary);
	}
	public static int get_emp_count()
	{
		return pe_count;
	}
}
