
public class A implements Sample{

	
	@Override
	public void hello() {
		System.out.println("Hello in class");
		Sample.super.hello();
	}
	
	
	public static void main(String[] args) {
		Sample s = new A();
		s.hello();
		
		
	}

	@Override
	public void abc() {
		// TODO Auto-generated method stub
		
	}
}
