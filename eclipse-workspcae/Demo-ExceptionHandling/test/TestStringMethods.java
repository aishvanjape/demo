import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestStringMethods {

	
	@Test
	public void testXYZ(){
	
		//fail("Not yet Implemented");
		int s = 0;
		int s1 = 0;
		//Integer i= new Integer(1);
		//Integer i1= 1;
		//Integer i2 = 1;
		Assert.assertSame(s, s1);
		//Assert.assertSame(i2, i1);
	}
	
	@Test
	public void testString(){
	
		String msg1 = new String("Hello");
		String msg2 = "Hello";
		String msg3 = "Hello";
		
		Assert.assertSame(msg2, msg3);
		
	}
	
	
}
