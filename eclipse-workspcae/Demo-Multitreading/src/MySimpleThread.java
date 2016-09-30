
public class MySimpleThread extends Thread {

	
	
	
	@Override
	public void run() {
		for(int v=0;v<10;v++)
		{
			System.out.println("Inside run"+Thread.currentThread());
		}
		
		try {
			Thread.sleep(15000);
			Thread t1 = new MySimpleThread();
			t1.start();
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
