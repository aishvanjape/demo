package com.simulationdemo;

public class Cat extends Feline{

	public Cat(String type, String location) {
		super(type, location);
	}

	private int size;
	
	public int getSize() {
		return size;
	}
	
	public void roam(){
		System.out.println("I roam alone....Cat");
	}
	
	
}
