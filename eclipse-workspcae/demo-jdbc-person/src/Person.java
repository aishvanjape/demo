import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Person {

	public static void main(String[] args) throws IOException {
		
		Properties props = new Properties();
		
		FileInputStream fln = new FileInputStream("dbDetails.properties");
		props.load(fln);
		
		
		
		
		
	}
}
