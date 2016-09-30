package com.cg;

public class Entry2 {

	static class String{
		
	}
	class Abc{
		
	}
	public static void main(java.lang.String[] args)
	{
		java.util.Date d1;
		d1=new java.util.Date();
		
		java.sql.Date d2;
		d2=new java.sql.Date(d1.getTime());
		String x = new Entry2.String();
		//Abc z = new Entry2.Abc();
		System.out.println(d2);
	}
}
