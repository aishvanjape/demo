import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Person {

	public static void main(String[] args) throws IOException, SQLException {
		
		Properties props = new Properties();
		
		FileInputStream fln = new FileInputStream("dbdetails.properties");
		props.load(fln);
		
		String url = props.getProperty("url");
		Connection dbconnection;
		
		dbconnection = DriverManager.getConnection(url);
	}
}
