package com.cg;

import java.util.LinkedList;
import java.util.List;

public class InMemoryDaoImpl implements IDao{
@Override
public List<String> getMessages() {

	String msg1 = "Hello";
	String msg2 = "How are u?";

	List<String> messages = new LinkedList<>();
	messages.add(msg1);
	messages.add(msg2);
	
	return messages;
}
}
