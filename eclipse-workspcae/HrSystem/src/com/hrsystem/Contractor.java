package com.hrsystem;

 public class Contractor {

	private static int ce_count=0;
	private String contractor_name;
	
	
	public Contractor(String name) 
	{
		this.contractor_name = name;	
	}
	
	public class ContractBaseEmp extends Employee {

		private int rate;
		private int no_of_hours;
		
		public ContractBaseEmp(String first_name, String last_name, String grade, String join,int rate,int no_of_hrs) {
			super(first_name, last_name, rate*no_of_hrs, grade, join);
			
			this.rate=rate;
			this.no_of_hours=no_of_hrs;
			ce_count++;
			
		}
		
		public void withdraw_salary()
		{
			System.out.println("Salary drawn for Contractbase Employee: "+(this.salary));
		}
		public String get_con_name()
		{
			return contractor_name;
		}
	}
	
	public static int get_emp_count()
	{
		return ce_count;
	}
}
