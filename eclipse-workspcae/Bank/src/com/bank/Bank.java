package com.bank;

public class Bank {

	Account accounts[];
	
	public Bank() {
		
		this.accounts = new Account[20];
	}
	
	public void showtotalbalance()
	{
		double totalbalance=0;
		
		for(int i = 0;i<8;i++)
		{
			totalbalance = totalbalance + this.accounts[i].get_balance();
		}
		
		System.out.println("Total Balance "+totalbalance);
	}
	public void createaccount(int id, Customer c)
	{
		this.accounts[id] = new Account(c, id);
	}
	
	public Customer createcustomer(int id, String name)
	{
		Customer c = new Customer(id, name);
		return c;
	}
	
	public int get_total_no_of_accounts()
	{
		return this.accounts.length;
	}
	
	public boolean transfer_amount(int from, int to, double amt) throws InterruptedException
	{
//		synchronized (accounts[from] ) {
//			synchronized (accounts[to]) {
//				this.accounts[from].withdraw(amt);  
//				this.accounts[to].deposit(amt);
//				return true;
//			}
//		}
		
		this.accounts[from].withdraw(amt);  
		this.accounts[to].deposit(amt);
		return true;
//		
//		this.accounts[from].getLock().lock();
//		this.accounts[to].getLock().lock();
//		
//		this.accounts[from].getLock().unlock();
//		this.accounts[to].getLock().unlock();
//		return true;
		
	}
}
