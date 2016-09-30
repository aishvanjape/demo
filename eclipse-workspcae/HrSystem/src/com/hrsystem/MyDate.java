package com.hrsystem;

public class MyDate{
private int dd,mm,yyyy;
MyDate(String s)
{
	String a[] = s.split("-");	
	dd = Integer.parseInt(a[0]);
	mm = Integer.parseInt(a[1]);
	yyyy = Integer.parseInt(a[2]);
}
public int getDd() {
	return dd;
}
public int getMm() {
	return mm;
}
public int getYyyy() {
	return yyyy;
}
}
