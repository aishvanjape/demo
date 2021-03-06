package com.pc;

public class Container {
	
	private int size;
	
	public Container() {
		size = 0;
	}
	synchronized
	public void put() throws InterruptedException
	{
		while(size == 1)
		{
			System.out.println("Producer waiting"+Thread.currentThread().getName());
			this.wait();
		}
		System.out.println("Producer producing product"+Thread.currentThread().getName());
		//Thread.sleep(1000);
		size = 1;
		System.out.println("Product produced"+Thread.currentThread().getName());
		System.out.println("Size in producer"+size);
		//Thread.sleep(1000);
		this.notifyAll();
	}
	synchronized
	public void get() throws InterruptedException
	{
		while(size == 0)
		{
			System.out.println("Consumer waiting"+Thread.currentThread().getName());
			this.wait();
		}
		System.out.println("Consumer consuming product"+Thread.currentThread().getName());
		//Thread.sleep(1000);
		size = 0;
		System.out.println("Product consumed"+Thread.currentThread().getName());
		System.out.println("Size in consumer"+size);
		//Thread.sleep(1000);
		this.notifyAll();
	}

}
