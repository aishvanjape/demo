package com.flp.ems.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceLocator {

	
	public static DataSource getDataSource(String datasourceJndiNAme)
	{
		DataSource datasource = null;
		
		Context context;
		try {
			context = new InitialContext();
			Context envContext = (Context) context.lookup("java:/comp/env");
			datasource = (DataSource) envContext.lookup(datasourceJndiNAme);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datasource;
	}
}



