package com.simulationdemo;

public class Animal {
	// DATA MEMBERS

	private String type;
	private String location;
	static String abc;
	public static int abc1()
	{
	return 0;	
	}
	public void roam(){
		System.out.println("inside roam() of Animal");
	}
	
	
	public Animal(String type, String location,String abc,int a,String l) {
		this.type = type;
		this.location = location;
	}

	public String getLocation() {
		return location;
	}
	
	public String getType() {
		return type;
	}
	
	
}
