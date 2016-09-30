package com.pc;

public class Producer implements Runnable{
	Container container;
	
	public Producer(Container c) {
		container = c;
	}
	
	@Override
	public void run() {
		
		try {
			
			this.container.put();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
