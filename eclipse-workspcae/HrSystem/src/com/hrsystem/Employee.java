package com.hrsystem;

class Employee
{
	private String first_name,last_name;
	protected int salary;
	private int emp_id;
	private String grade;
	private MyDate join_month;
	static int e_count=0;
	public Employee(String first_name,String last_name,int salary,String grade,String join)
	{
		this.emp_id=++e_count;
		this.first_name=first_name;
		this.last_name=last_name;
		this.salary=salary;
		this.grade=grade;
		this.join_month = new MyDate(join);
	}
	void display()
	{
		System.out.println(this.emp_id+"\n"+this.first_name+"\n"+this.last_name+"\n"+this.salary+"\n"+this.grade+"\n"+this.join_month.getDd()+"-"+this.join_month.getMm()+"-"+this.join_month.getYyyy());
	}
	public static int get_count()
	{
		return e_count;
	}
	public void withdraw_salary()
	{
		System.out.println("Withdrawn Salary from Employee class");
	}
	public int getEmp_id() {
		return emp_id;
	}
}