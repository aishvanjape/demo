
public class Entry {
public static void main(String[] args) {
	System.out.println("Hello World");
	
	Thread t1 = new MySimpleThread();
	t1.start();
	//t1.start();
}
}