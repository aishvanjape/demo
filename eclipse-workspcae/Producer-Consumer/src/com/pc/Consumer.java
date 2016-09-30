package com.pc;

public class Consumer implements Runnable{
	
	Container container;
	
	public Consumer(Container c) {
		container = c;
	}
	@Override
	public void run() {
		
		try {
			
			this.container.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
