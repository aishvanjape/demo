package com.bank;

import java.util.Random;

public class Teller implements Runnable{

	Bank b;
	public Teller(Bank bank) {
		b = bank;
	}
	@Override
	public void run() {
		
		Random r = new Random();
		int accto = r.nextInt(8);
		int accfrom = r.nextInt(8);
		//System.out.println("Before Transaction");
		
		try {
			//b.showtotalbalance();
			if(b.transfer_amount(accfrom, accto, 200))
			{
				//System.out.println("After Transaction");
				//b.showtotalbalance();
				System.out.println("Transaction successful for accounts from "+accfrom+"to "+accto);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
