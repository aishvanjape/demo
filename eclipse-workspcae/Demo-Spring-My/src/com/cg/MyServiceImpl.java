package com.cg;

import java.util.List;

public class MyServiceImpl implements IService{
	
	private IDao daoRef;
	
	
	public void setDaoRef(IDao daoRef) {
		this.daoRef = daoRef;
	}

	@Override
	public List<String> getMessages() {
		return daoRef.getMessages();
	}
}
