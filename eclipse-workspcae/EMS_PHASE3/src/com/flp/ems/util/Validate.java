package com.flp.ems.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validate {

	static public Date validate_Date(String date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Date valid_date = new Date();
		valid_date = sdf.parse(date);
		return valid_date;
	}
	
	
}
