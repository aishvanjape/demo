package com.simulationdemo;

public class Lion extends Feline{

	public Lion(String type, String location) {
		super(type, location);
	}

	private int size;
	
	public int getSize() {
		return size;
	}
	
	public void roam(){
		System.out.println("I roam alone....Lion");
	}
	
	
}
