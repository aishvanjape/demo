package com.hrsystem;

public class EmployeeId implements Comparable{
int id;
String suffix,emp_key;
public EmployeeId(int i, String s) {
	id = i;
	suffix = s;
	emp_key = i+"_"+s;
}
@Override
	public int compareTo(Object o) {
	
	return this.emp_key.compareTo(((EmployeeId)o).emp_key);
}

@Override
	public String toString() {
		return id+"_"+suffix;
	}
@Override
public int hashCode() {
	/*
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((suffix == null) ? 0 : suffix.hashCode());
	return result;
	*/
	return id;
}
@Override
public boolean equals(Object obj) {
	/*if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EmployeeId other = (EmployeeId) obj;
	if (id != other.id)
		return false;
	if (suffix == null) {
		if (other.suffix != null)
			return false;
	} else if (!suffix.equals(other.suffix))
		return false;
	return true;
	*/
	if((this.id == ((EmployeeId)obj).id) && (this.suffix) == ((EmployeeId)obj).suffix)
	{
		return true;
	}
	return false;
}
}
