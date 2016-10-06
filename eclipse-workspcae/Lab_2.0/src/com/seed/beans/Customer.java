package com.seed.beans;

public class Customer {
	private long mobile;
	private int pincode;
	private String name;
	
//	TODO:1	Provide no-argument public constructor
	public Customer() {
		// TODO Auto-generated constructor stub
	}
//	TODO:2	Provide getters and setters for all attributes.
	public long getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public int getPincode() {
		return pincode;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
