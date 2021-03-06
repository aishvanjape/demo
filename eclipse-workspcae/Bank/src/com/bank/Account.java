package com.bank;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	Customer c;
	int id;
	double balance;
	Lock lock = new ReentrantLock();
	
	public Lock getLock() {
		return lock;
	}
	
	public Account(Customer c, int id) {
		this.c = c;
		this.id = id;
		this.balance = 5000;
	}
	synchronized
	public boolean deposit(double amt) throws InterruptedException
	{
		double bal = this.balance;
		Thread.sleep((long)(500*Math.random()));
		bal = bal + amt;
		Thread.sleep((long)(1000*Math.random()));
		this.balance = bal;
		Thread.sleep(500);
		return true;
	}
	synchronized
	public boolean withdraw(double amt) throws InterruptedException
	{
		double bal = this.balance;
		Thread.sleep((long)(100*Math.random()));
		bal = bal - amt;
		Thread.sleep(500);
		this.balance = bal;
		Thread.sleep(1500);
		return true;
	}
	//synchronized
	public double get_balance()
	{
		return this.balance;
	}
}
