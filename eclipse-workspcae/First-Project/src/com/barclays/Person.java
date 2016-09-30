package com.barclays;

public class Person {

	// DATA MEMBERS

	private String name;
	private int age;
	private static int count;
	
	
	// MEMBER METHODS

	public Person() {
		name = "Not Available";
		age = 18;
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static int getCount(){
		return Person.count;
	}


	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
