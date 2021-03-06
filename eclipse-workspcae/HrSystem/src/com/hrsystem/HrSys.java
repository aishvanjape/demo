package com.hrsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class HrSys
{	
	public static void main(String[] args) throws Exception
	{
		/*Employee e1 = new Employee("ABC","XYZ",200000,"BA3","01-08-2016");
		e1.display();
		Employee e2 = new Employee("PQR","DEF",500000,"BA4","01-01-2012");
		e2.display();
		Employee e3 = new Employee("ABC","DDD",3000000,"AVP","15-03-2013");
		e3.display();
		System.out.println("No. of employees added:"+Employee.get_count());
		
		Employee e;
		e = new PermanentEmp("ABC","XYZ",200000,"BA3","01-08-2016");
		e.display();
		e.withdraw_salary();
		//PermanentEmp p2 = new PermanentEmp("PQR","DEF",500000,"BA4","01-01-2012"); 
		//p2.display();
		//p2.draw_salary();
		Contractor con= new Contractor("ABCDEF");
		e=con.new ContractBaseEmp("DFG", "JKL", "BA3", "01-02-2013",15,40);
		e.display();
		e.withdraw_salary();
		
		e=con.new ContractBaseEmp("FGH", "SDD", "BA3", "02-02-2013",20,60);
		e.display();
		e.withdraw_salary();
		System.out.println("Permanent Employees Added"+PermanentEmp.get_emp_count());
		System.out.println("ContractBase Employees Added"+Contractor.get_emp_count());
		System.out.println("No. of employees added:"+Employee.get_count());
		
		
		Employee emp[];
		emp = new Employee[5];
		*/
		
		
		
		//ArrayList<Employee> emp = new ArrayList<Employee>();
		Contractor con= new Contractor("ABCDEF");
		Map<EmployeeId,Employee> m = new TreeMap();
		Employee e1 = new PermanentEmp("ABC","XYZ",200000,"BA3","01-08-2016");
		Employee e2 = new PermanentEmp("PQR","DEF",500000,"BA4","01-01-2012");
		Employee e3 = con.new ContractBaseEmp("DFG", "JKL", "BA3", "01-02-2013",15,40);
		Employee e4 = con.new ContractBaseEmp("FGH", "JKL", "BA3", "01-02-2013",15,40);
		
		m.put(new EmployeeId(e1.getEmp_id(),"ABC"), e1);
		m.put(new EmployeeId(e2.getEmp_id(), "PQR"), e2);
		m.put(new EmployeeId(e3.getEmp_id(), "JKL"), e3);
		m.put(new EmployeeId(e4.getEmp_id(), "GHI"), e4);
		
		//Set<Map.Entry<EmployeeId,Employee>> set = m.entrySet();
		/*
		for( Map.Entry<EmployeeId,Employee> entry :set){
			System.out.print(entry.getKey()+"\t");
			System.out.println(entry.getValue().getEmp_id());
		}
		*/
		/*
		emp.add(new PermanentEmp("ABC","XYZ",200000,"BA3","01-08-2016"));
		emp.add(new PermanentEmp("PQR","DEF",500000,"BA4","01-01-2012"));
		emp.add(con.new ContractBaseEmp("DFG", "JKL", "BA3", "01-02-2013",15,40));
		emp.add(con.new ContractBaseEmp("FGH", "JKL", "BA3", "01-02-2013",15,40));
		
		for(int i=0;i<4;i++)
		{
			emp[i].display();
		}
		*/
		try{
			search(m,new EmployeeId(e1.getEmp_id(),"ABC"));
		}catch(EmployeeNotFound e)
		{
			System.out.println("Employee not found in main");
		}
	}

	public static void search(Map<EmployeeId,Employee> emp,EmployeeId e) throws EmployeeNotFound 
	{
		try{
			
			System.out.println(e);
			
			if(emp.containsKey(e))
			{
				System.out.println("Employee found");}
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