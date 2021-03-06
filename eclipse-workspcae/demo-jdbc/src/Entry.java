import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class Entry {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		//TODO LOAD JDBC PROPERTIES FROM FILE SYSTEM
		Properties props = new Properties();
		
		
		
		FileInputStream fln = new FileInputStream("dbDetails.properties");
		props.load(fln);
		
	
		
		//TODO LOAD AND REGISTER "JDBC DRIVER"
		
		//REQUIRED FOR JDBC 3 OR BELOW
		
		
		String driver = props.getProperty("jdbc.driver");
		Class.forName(driver);
		
		//TODO GET DATABASE CONNECTION USING "JDBC URL"
		
		String url = props.getProperty("jdbc.url");
		Connection dbConnection;
		
		dbConnection = DriverManager.getConnection(url);
		
		System.out.println("Connection successful?"+(dbConnection!=null));
		Statement stmt = null;
		
		String query = props.getProperty("jdbc.query.insert");
		
//		try{
//		stmt = dbConnection.createStatement();
//		
//		int rows;
//		
//		rows = stmt.executeUpdate(query);
//		
//		System.out.println(rows+" Records added successfully");
//		}finally{
//			if(stmt != null)
//			{
//				stmt.close();
//			}
//		}
		try(Statement selectstmt = dbConnection.createStatement())
		{
			String selectquery = props.getProperty("jdbc.query.select");
			
			ResultSet result ;
			
			result = selectstmt.executeQuery(selectquery);
			
			while(result.next())
			{
				System.out.println(result.getString(1));
			}
		}
		
		String insertquery = props.getProperty("jdbc.query.insert");
		try(PreparedStatement insertstmt = dbConnection.prepareStatement(insertquery)){
		
			
			String msg = "New msg";
			int x=1;
			insertstmt.setString(1, msg);
			insertstmt.setInt(2, x);
			insertstmt.executeUpdate();
			
		}
	
		
	}
}
