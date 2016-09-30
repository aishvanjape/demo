package com.barclays;

public class Entry {
	
public static void main(String[] args) {
	System.out.println("Hello,World..!!");
	Person p;
		p=null;
		p=new Person();

		System.out.println(p.getName());
		System.out.println(p.getAge());
		p=null;
		
		System.out.println(Person.getCount());
}
}
