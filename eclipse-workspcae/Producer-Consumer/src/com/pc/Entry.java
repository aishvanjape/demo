package com.pc;

public class Entry {
	
	public static void main(String[] args) {
		
		Container c = new Container();
		Consumer cons = new Consumer(c);
		Producer prod = new Producer(c);
		Thread t1 = new Thread(cons);
		Thread t2 = new Thread(prod);
		Thread t3 = new Thread(prod);
		Thread t6 = new Thread(prod);
		Thread t4 = new Thread(cons);
		Thread t5 = new Thread(cons);
		
			t1.start();
			t2.start();
			t4.start();
			t6.start();
			t3.start();
			t5.start();
	}

}
