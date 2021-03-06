import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


	


public class Person {

	
	//public static void main(String[] args) throws IOException, SQLException {
	public static final synchronized strictfp void main(String[] args)throws IOException, SQLException{
		Properties props = new Properties();
		
		FileInputStream fln = new FileInputStream("dbdetails.properties");
		props.load(fln);
		
		String url = props.getProperty("jdbc.url");
		Connection dbconnection;
		
		dbconnection = DriverManager.getConnection(url);
		int rows;
		String query = props.getProperty("jdbc.query.insert");
		Statement selectstmt = dbconnection.createStatement();
		try(PreparedStatement insertstmt = dbconnection.prepareStatement(query)){
		
			
			insertstmt.setString(1, "ABC");
			insertstmt.setInt(2, 1);
			rows=insertstmt.executeUpdate();
			System.out.println("rows added"+rows);
			insertstmt.setString(1, "PQR");
			insertstmt.setInt(2, 1);
			rows=insertstmt.executeUpdate();
			
			System.out.println("rows added"+rows);
			
String selectquery = props.getProperty("jdbc.query.select");
			
			ResultSet result ;
			
			result = selectstmt.executeQuery(selectquery);
			
			while(result.next())
			{
				System.out.println(result.getString(1));
			}
			
		
		}
	}
}
