package com.cg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.cg.dao.CarDAO;
import com.cg.dto.CarDTO;
import com.cg.util.ServiceLocator;
import com.cg.util.ServiceLocatorException;

//TODO 1 Import appropriate classes based on following TODOs
//Follow TODOs (if available)
/**
 * 
 * This is a JDBCCarDAO class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
 
 //TODO 2 Implement appropriate Interface
public class JDBCCarDAO implements CarDAO{
	//TODO 3 Declare a local variable datasource of type DataSource follow encapsulation principle
	DataSource datasource;

	
	public JDBCCarDAO() {
		//TODO 4 Initialize the dataSource in TODO 3 using ServiceLocator API
		//TODO 5 If any error occur in getting this service then throw ServiceLocatorException
		//with error message as 'Container Service not available'
		
		try{
			datasource = ServiceLocator.getDataSource("");
		}catch(Exception e)
		{
			throw new ServiceLocatorException("Container Service not available");
		}
	
		
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	@Override
	/**
	 * This method is mapped to ADD_CAR_ACTION
	 * @param car a CarDTO 
	 */
	public void create(CarDTO car) {
		// TODO Auto-generated method stub
		Connection connection = null;

		String insertQuery = "insert into Car (MAKE,MODEL,MODEL_YEAR) values(?,?,?)";
		
		try{
			try {
				//TODO 6 
				//Get a connection using datasource
				//Start the JDBC transaction
				//Create a PreparedStatement using insertQuery
				//Set the parameters of the PreparedStatement
				//Invoke appropriate API of JDBC to update and commit the record
				
				connection = datasource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement insertstmt = connection.prepareStatement(insertQuery);
				insertstmt.setString(1, car.getMake());
				insertstmt.setString(2, car.getModel());
				insertstmt.setString(3, car.getModelYear());
				insertstmt.executeUpdate();
			} 
			catch (SQLException e) {
//				e.printStackTrace();
				
				if (connection != null)
					connection.rollback();
				throw e;
			} 
			finally {
				if (connection != null)
					connection.close();			
			}
		}
		catch(SQLException e){
			throw new JDBCDaoException("SQL error while excecuting this query: "+ insertQuery,e);
		}
		
	}

	@Override
	/**
	 * This method is mapped to DELETE_CAR_ACTION
	 * @param ids collection of CAR ids. 
	 */
	public void delete(String[] ids) {
		Connection connection = null;
		String deleteQuery = "delete from car where id=?";

		try{
			try {
				//TODO 7 
				//Get a connection using datasource
				//Start the JDBC transaction
				//Create a PreparedStatement using deleteQuery
				//Set the parameters of the PreparedStatement
				//Invoke appropriate API of JDBC to update and commit the record
				
				connection = datasource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement deletestmt = connection.prepareStatement(deleteQuery);
				for(String id:ids)
				{
					deletestmt.setInt(1, Integer.parseInt(id));
					deletestmt.executeUpdate();
				}
				
			} 
			catch (SQLException e) {
				if (connection != null)
					connection.rollback();	
				
				throw e;
			} 
			finally {
				if (connection != null)
					connection.close();				
			}
		}
		catch(SQLException e){
			throw new JDBCDaoException("SQL error while excecuting query: "+ deleteQuery,e);
		}		
	}

	@Override
	/**
	 * This method is mapped to EDIT_CAR_ACTION
	 * @param car a CarDTO 
	 */
	public void update(CarDTO car) {
		// TODO Auto-generated method stub
		String updateQuery = "update car set make=?,model=?,model_year=? where id=?";
		Connection connection = null;
		
		try{
			try {
				//TODO 8 
				//Get a connection using datasource
				//Start the JDBC transaction
				//Create a PreparedStatement using updateQuery
				//Set the parameters of the PreparedStatement
				//Invoke appropriate API of JDBC to update and commit the record
				
				connection = datasource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement updatestmt = connection.prepareStatement(updateQuery);
				updatestmt.setString(1, car.getMake());
				updatestmt.setString(2, car.getModel());
				updatestmt.setString(3, car.getModelYear());
				updatestmt.setInt(4, car.getId());
				updatestmt.executeUpdate();
				
			} 
			catch (SQLException e) {
				if(connection != null)
					connection.rollback();
				
				throw e;
			}
			finally {
				if (connection != null)
					connection.close();			
			}
		}
		catch(SQLException e){
			throw new JDBCDaoException("SQL error while excecuting query: "+ updateQuery,e);
		}
	}
	
	
	@Override
	/**
	 * This method is mapped to VIEW_CAR_LIST_ACTION
	 * @return List list of cars 
	 */
	public List<CarDTO> findAll() {
		List<CarDTO> carList = new ArrayList<CarDTO>();

		Connection connection = null;
		String selectQuery = "select * from CAR";
		
		try{
			try {
				//TODO 9 
				//Get a connection using datasource
				//Don't start the JDBC transaction
				//Create a Statement using selectQuery
				//Invoke appropriate API of JDBC to fire the query
				//For iteration over the ResultSet populate carList with CarDTO 
				
				connection = datasource.getConnection();
				connection.setAutoCommit(false);
				Statement selectstmt = connection.createStatement();
				ResultSet res = selectstmt.executeQuery(selectQuery);
				CarDTO car = new CarDTO();
				while(res.next())
				{
					car.setId(res.getInt("id"));
					car.setMake(res.getString("make"));
					car.setModel(res.getString("model"));
					car.setModelYear(res.getString("MODEL_YEAR"));
					carList.add(car);
				}
				
				
			} 
			finally {
				if (connection != null)
					connection.close();				
			}
		}
		catch(SQLException e){
			throw new JDBCDaoException("SQL error while excecuting query: "+ selectQuery,e);
		}		

		return carList;
	}

	@Override
	/**
	 * This method is utility method for finding car by id.
	 * @param id id of the car to be searched
	 * @return  CarDTO A CarDTO
	 */
	public CarDTO findById(int id) {
		// TODO Auto-generated method stub
		String selectQuery = "select * from CAR where id=?";
		CarDTO car = new CarDTO();
		Connection connection = null;
		
		try{
			try {
				connection = datasource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement selectStatement = connection
				.prepareStatement(selectQuery);
				selectStatement.setInt(1, id);
				ResultSet result = selectStatement.executeQuery();
				result.next();

				car.setId(result.getInt("id"));
				car.setMake(result.getString("make"));
				car.setModel(result.getString("model"));
				car.setModelYear(result.getString("MODEL_YEAR"));
			} 
			finally {
				if (connection != null)
					connection.close();			
			}
		}
		catch(SQLException e){
			throw new JDBCDaoException("SQL error while excecuting query: "+ selectQuery,e);
		}		

		return car;
	}

	

}
