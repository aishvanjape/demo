class Z extends Thread{
	private int i;
	public void run()
	{
		i=1;
	}
	public static void main(String[] args) throws InterruptedException {
		Z b = new Z();
		b.start();
		b.join();
		System.out.println(b.i);
	}
}
