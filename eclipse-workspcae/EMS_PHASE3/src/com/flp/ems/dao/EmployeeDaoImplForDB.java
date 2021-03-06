package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.flp.ems.domain.Employee;
import com.flp.ems.util.ServiceLocator;


public class EmployeeDaoImplForDB implements IEmployeeDao{
	
		private Properties props;
		//private FileInputStream fln;
		private String url;
	public EmployeeDaoImplForDB() 
	{
		
		try {

			props = new Properties();
			InputStream inputStream = (InputStream) getClass().getClassLoader().getResourceAsStream("/dbDetails.properties");
			props.load(inputStream);
			url = props.getProperty("jdbc.url");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	

	@Override
	public void AddEmployee(Employee newemployee) {
		Connection dbConnection;
		String insertquery;
		try {
			dbConnection=ServiceLocator.getDataSource("jdbc/MyDataSource").getConnection();
			insertquery=props.getProperty("jdbc.query.insert");
			try(PreparedStatement insertstmt = dbConnection.prepareStatement(insertquery))
			{
				insertstmt.setString(1, newemployee.getKin_Id());
				insertstmt.setString(2, newemployee.getName());
				insertstmt.setString(3, newemployee.getEmail_Id());
				insertstmt.setInt(4, (int) newemployee.getPhone_no());
				insertstmt.setDate(5, new java.sql.Date(newemployee.getDate_Of_Birth().getTime()));
				insertstmt.setDate(6, new java.sql.Date(newemployee.getDate_Of_Joining().getTime()));
				insertstmt.setString(7, newemployee.getAddress());
				insertstmt.setInt(8, (int) newemployee.getDepartment_Id());
				insertstmt.setInt(9, (int) newemployee.getProject_Id());
				insertstmt.setInt(10, (int) newemployee.getRole_Id());
				
				insertstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public boolean ModifyEmployee(Employee employee) {
		Connection dbConnection;
		ResultSet res;
		try {
			dbConnection=ServiceLocator.getDataSource("jdbc/MyDataSource").getConnection();
			try(PreparedStatement updatestmt=dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.kinid"), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE))
			{
				updatestmt.setString(1, employee.getKin_Id());
				res = updatestmt.executeQuery();
				res.first();
				res.updateString(2, employee.getName());
				res.updateRow();
				res.updateString(3, employee.getEmail_Id());
				res.updateRow();
				res.updateInt(4, (int)employee.getPhone_no());
				res.updateRow();
				res.updateDate(5, new java.sql.Date(employee.getDate_Of_Birth().getTime()));
				res.updateRow();
				res.updateDate(6, new java.sql.Date(employee.getDate_Of_Joining().getTime()));
				res.updateRow();
				res.updateString(7, employee.getAddress());
				res.updateRow();
				res.updateInt(8, (int)employee.getDepartment_Id());
				res.updateRow();
				res.updateInt(9, (int)employee.getProject_Id());
				res.updateRow();
				res.updateInt(10, (int)employee.getRole_Id());
				res.updateRow();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean RemoveEmployee(Employee employee) {
		Connection dbConnection;
		try {
			dbConnection=ServiceLocator.getDataSource("jdbc/MyDataSource").getConnection();
			try(PreparedStatement removestmt=dbConnection.prepareStatement(props.getProperty("jdbc.query.delete")))
			{
				removestmt.setString(1, employee.getKin_Id());
				removestmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee SearchEmployee(HashMap<String, String> hashfield) {
		Employee receivedemployee=null;
		Connection dbConnection;
		ResultSet res;
		
//		String key=null,value=null;
		
		String key_name,key_kin,key_email;
		
		key_name = hashfield.get("Name");
		key_kin = hashfield.get("Kin_Id");
		key_email = hashfield.get("Email_Id");

		try {
			dbConnection=ServiceLocator.getDataSource("jdbc/MyDataSource").getConnection();
			if(key_name.equals("NA") && !key_kin.equals("NA") && !key_email.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.kin.emailid")))
				{
					searchstmt.setString(1, key_kin);
					searchstmt.setString(2, key_email);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}	
			}
			else if(key_kin.equals("NA") && !key_name.equals("NA") && !key_email.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.name.emailid")))
				{
					searchstmt.setString(1, key_name);
					searchstmt.setString(2, key_email);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}	
			}
			else if(key_email.equals("NA") && !key_name.equals("NA") && !key_kin.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.kin.name")))
				{
					searchstmt.setString(1, key_kin);
					searchstmt.setString(2, key_name);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}
			}
			else if(key_name.equals("NA") && key_kin.equals("NA") && !key_email.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.emailid")))
				{
					searchstmt.setString(1, key_email);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}
			}
			else if(key_kin.equals("NA") && key_email.equals("NA") && !key_name.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.name")))
				{
					searchstmt.setString(1, key_name);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}
			}
			else if(key_email.equals("NA") && key_name.equals("NA") && !key_kin.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.kinid")))
				{
					searchstmt.setString(1, key_kin);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
					
				}
			}
			else if(!key_email.equals("NA") && !key_name.equals("NA") && !key_kin.equals("NA"))
			{
				try(PreparedStatement searchstmt = dbConnection.prepareStatement(props.getProperty("jdbc.query.search.on.all")))
				{
					searchstmt.setString(2, key_name);
					searchstmt.setString(3,key_email);
					searchstmt.setString(1, key_kin);
					res = searchstmt.executeQuery();
					if(res.next())
					{
						//res.first();
						receivedemployee = new Employee(res.getString(2),res.getInt(4),res.getDate(5),res.getDate(6),res.getString(7),res.getInt(8),res.getInt(9),res.getInt(10));
						receivedemployee.setKin_Id(res.getString(1));
						receivedemployee.setEmail_Id(res.getString(3));
					}
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receivedemployee;
	}

	@Override
	public ArrayList getAllEmployee()  {
		Connection dbConnection;
		ArrayList<Employee> employeelist = new ArrayList<Employee>();
		ResultSet result;
		try {
			dbConnection=ServiceLocator.getDataSource("jdbc/MyDataSource").getConnection();
			try(Statement selectstmt = dbConnection.createStatement())
			{
				String selectquery = props.getProperty("jdbc.query.select");
				result = selectstmt.executeQuery(selectquery);
				
				while(result.next())
				{
					
					Employee emp = new Employee(result.getString(2),result.getInt(4),result.getDate(5),result.getDate(6),result.getString(7),result.getInt(8),result.getInt(9),result.getInt(10));
					emp.setKin_Id(result.getString(1));
					emp.setEmail_Id(result.getString(3));
				    employeelist.add(emp);
				    
				}
				return employeelist;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}