package com.flp.ems.util;

import com.flp.ems.dao.EmployeeDaoImplForDB;
import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IEmployeeDao;

public class DBUtility {

	
		static IEmployeeDao employeedao = new EmployeeDaoImplForDB();
	
		
		public static IEmployeeDao getEmployeedao() {
			return employeedao;
		}

	}







