package com.bank;

public class Entry {

	public static void main(String[] args) throws InterruptedException  {
		
		Bank bank = new Bank();
		
		Customer c1 = bank.createcustomer(1, "ABC");
		Customer c2 = bank.createcustomer(2, "XYZ");
		Customer c3 = bank.createcustomer(3, "PQR");
		bank.createaccount(0, c1);
		bank.createaccount(1, c1);
		bank.createaccount(2, c1);
		bank.createaccount(3, c2);
		bank.createaccount(4, c2);
		bank.createaccount(5, c2);
		bank.createaccount(6, c3);
		bank.createaccount(7, c3);
		
		
		
		Runnable teller1 = new Teller(bank);
		bank.showtotalbalance();
		
		Thread t1 = new Thread(teller1);
		
		Thread t2 = new Thread(teller1);
		
		Thread t3 = new Thread(teller1);
		
		Thread t4 = new Thread(teller1);
		
		Thread t5 = new Thread(teller1);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		
		bank.showtotalbalance();
	}
}
