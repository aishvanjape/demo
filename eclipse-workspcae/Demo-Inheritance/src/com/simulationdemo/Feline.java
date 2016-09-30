package com.simulationdemo;

public class Feline extends Animal{

	public Feline(String type, String location) {
		super(type, location,abc,abc1(),"");
		// TODO Auto-generated constructor stub
	}

	public void roam(){
		System.out.println("I roam alone....");
	}
	public String getloc()
	{
		return "";
	}

	/*	public Feline() {
//		CHAINING CONSTRUCTOR USING 'super'
		super("NA","NA");
	}
*/
	


}
