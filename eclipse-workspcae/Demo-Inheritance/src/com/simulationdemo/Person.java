package com.simulationdemo;

public class Person implements Comparable{

	String name;
	int age;
	@Override
	public int compareTo(Object o) {
		
		return 0;
	}
	@Override
	public String toString() {
		
		return "["+name+"/"+age+"]";
	}
	public Person(String s,int a)
	{
		name = s;
		age = a;
	}
}