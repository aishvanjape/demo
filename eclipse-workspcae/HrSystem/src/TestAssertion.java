
public class TestAssertion {

	public static void main(String[] args) {
		
		int distance = 90;
		
		System.out.println("some logic executed");
		
		assert(distance > 0);
		
		System.out.println("some logic executed again");
		
		distance = -90;
		
		assert(distance > 0);
		
		System.out.println("at the end of main");
		
	}
	
}
