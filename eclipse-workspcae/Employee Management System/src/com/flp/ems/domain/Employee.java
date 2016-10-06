package com.flp.ems.domain;

import java.util.Date;

public class Employee implements Cloneable{
	
	
	//Data Members
	
	private String Name;
	private String Kin_Id;
	private String Email_Id;
	private long Phone_no;
	private Date Date_Of_Birth;
	private Date Date_Of_Joining;
	private String Address;
	private long Department_Id;
	private long Project_Id;
	private long Role_Id;
	private static long count = 0;
	
//	@Override
//	public int hashCode() {
//			return Name.hashCode();	
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(this == obj)
//		{
//			return true;
//		}
//		else{
//			return this.Name.equals(((Employee)obj).Name);
//		}
//	}

	{
		count++;
	}
	
//	public Employee(Employee e)
//	{
//		this.Name = e.Name;
//		this.Kin_Id = e.Kin_Id;
//		this.Email_Id = e.Email_Id;
//		this.Phone_no = e.Phone_no;
//		this.Date_Of_Birth = e.Date_Of_Birth;
//		this.Date_Of_Joining = e.Date_Of_Joining;
//		this.Address = e.Address;
//		this.Department_Id = e.Department_Id;
//		this.Project_Id = e.Project_Id;
//		this.Role_Id = e.Role_Id;
//		
//	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email_Id == null) ? 0 : Email_Id.hashCode());
		result = prime * result + ((Kin_Id == null) ? 0 : Kin_Id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Email_Id == null) {
			if (other.Email_Id != null)
				return false;
		} else if (!Email_Id.equals(other.Email_Id))
			return false;
		if (Kin_Id == null) {
			if (other.Kin_Id != null)
				return false;
		} else if (!Kin_Id.equals(other.Kin_Id))
			return false;
		return true;
	}


	public Employee(String name,long phone_no, Date date_Of_Birth,
			Date date_Of_Joining, String address, long department_Id, long project_Id, long role_Id) {
		Name = name;
		Kin_Id = "K_"+count;
		Email_Id = name+"@company.com";
		Phone_no = phone_no;
		Date_Of_Birth = date_Of_Birth;
		Date_Of_Joining = date_Of_Joining;
		Address = address;
		Department_Id = department_Id;
		Project_Id = project_Id;
		Role_Id = role_Id;
	}
	

	public long getPhone_no() {
		return Phone_no;
	}

	public void setPhone_no(long phone_no) {
		Phone_no = phone_no;
	}

	public Date getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(Date date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

	public Date getDate_Of_Joining() {
		return Date_Of_Joining;
	}

	public void setDate_Of_Joining(Date date_Of_Joining) {
		Date_Of_Joining = date_Of_Joining;
	}

	public long getDepartment_Id() {
		return Department_Id;
	}
	
	public long getProject_Id() {
		return Project_Id;
	}

	public long getRole_Id() {
		return Role_Id;
	}
	
	public String getKin_Id() {
		return Kin_Id;
	}
	
	public String getEmail_Id() {
		return Email_Id;
	}
	
	public String getName() {
		return Name;
	}
	public void setKin_Id(String kin_id)
	{
		Kin_Id = kin_id;
	}
	public void setEmail_Id(String email_id)
	{
		Email_Id = email_id;
	}
	@Override
	public String toString() {
		return "\nEmployee :\nName=" + Name + ", \nKin_Id=" + Kin_Id + ", \nEmail_Id=" + Email_Id + ", \nDepartment_Id="
				+ Department_Id + ", \nProject_Id=" + Project_Id + ", \nRole_Id=" + Role_Id +", \nPhone No:"+Phone_no+", \nDate O Birth:"+Date_Of_Birth;
	}

	@Override
	public Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
		
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setDepartment_Id(long department_Id) {
		Department_Id = department_Id;
	}

	public void setProject_Id(long project_Id) {
		Project_Id = project_Id;
	}

	public void setRole_Id(long role_Id) {
		Role_Id = role_Id;
	}
}
