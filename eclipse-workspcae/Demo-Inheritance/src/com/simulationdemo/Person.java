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
//	public Person(String s,int a)
//	{
//		name = s;
//		age = a;
//	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
}
