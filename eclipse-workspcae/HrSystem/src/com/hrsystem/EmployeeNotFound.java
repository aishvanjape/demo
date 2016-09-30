package com.hrsystem;

public class EmployeeNotFound extends Exception {

	public EmployeeNotFound(String s) {
		super(s);
		//System.out.println("New Employee Not Found Exception Created..!!");
	}
	@Override
	public String getMessage() {
		
		return super.getMessage();
	}
}
