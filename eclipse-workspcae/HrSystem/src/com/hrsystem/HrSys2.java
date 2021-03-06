package com.hrsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.hrsystem.Contractor.ContractBaseEmp;

public class HrSys2 {

	public static void main(String[] args) {
		HashMap<EmployeeId, Employee> hm =new HashMap();
		
		Contractor con= new Contractor("ABCDEF");
		Map<EmployeeId,Employee> m = new TreeMap();
		Employee e1 = new PermanentEmp("ABC","XYZ",200000,"BA3","01-08-2016");
		Employee e2 = new PermanentEmp("PQR","DEF",500000,"BA4","01-01-2012");
		Employee e3 = con.new ContractBaseEmp("DFG", "JKL", "BA3", "01-02-2013",15,40);
		Employee e4 = con.new ContractBaseEmp("FGH", "JKL", "BA3", "01-02-2013",15,40);
		
		hm.put(new EmployeeId(e1.getEmp_id(),"ABC"), e1);
		hm.put(new EmployeeId(e2.getEmp_id(), "PQR"), e2);
		hm.put(new EmployeeId(e3.getEmp_id(), "JKL"), e3);
		hm.put(new EmployeeId(e4.getEmp_id(), "GHI"), e4);
	
		
		try{
			searchhashmap(hm,new EmployeeId(e1.getEmp_id(),"ABC"));
		}catch(EmployeeNotFound e)
		{
			System.out.println("Employee not found in main");
		}
		
	
	}
	
	
	public static void searchhashmap(HashMap<EmployeeId,Employee> emp,EmployeeId e) throws EmployeeNotFound 
	{
		try{
			
			System.out.println(e);
			
			if(emp.containsKey(e))
			{
				System.out.println("Employee found in hashmap");}
			else throw new EmployeeNotFound("Emp not found");
			/*
			int i,fl=0;
			Iterator itr = emp.iterator();
			while(itr.hasNext())
			{
				fl=0;
				if(((Employee)itr.next()).getEmp_id() == 5)
				{
					System.out.println("Employee found..!!");
					fl = 1;
					break;
				}
			}
			if(fl==0){throw new EmployeeNotFound("Not found");}
			*/
		}catch(EmployeeNotFound ef)
		{
			//System.out.println("Employee Not Found Exception Catched in search..!!");
			System.out.println(ef.getMessage());
			throw new EmployeeNotFound("Emp not found");
		}
		finally{
			System.out.println("Reached finally");
		}
	}
}
