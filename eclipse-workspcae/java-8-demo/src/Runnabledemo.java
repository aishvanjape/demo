
public class Runnabledemo {
public static void main(String[] args) {
	
	
	
	
	Runnable r1 = () -> System.out.println(Thread.currentThread().getName());
	Runnable r = new Runnable() {
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
			
		}
	};
	
	Thread t = new Thread(r);
	t.start();
	new Thread(r1).start();
	
}
}
