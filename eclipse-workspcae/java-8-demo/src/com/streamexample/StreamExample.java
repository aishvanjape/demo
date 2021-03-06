package com.streamexample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<>();
		List<String>l2 = new ArrayList<>();
		l2.add("a");
		l2.add("b");
		l.add("a");
		l.add("");
		l.add("");
		l.add("b");
		System.out.println(l);
		
		
		int count = (int)l.stream().filter(string -> string.isEmpty()).count();
		//List<String> l1 = l.stream().filter(string -> string.isEmpty()).collect(Collectors.toList());
		List<String> filtered = l2.stream().filter(string ->                                                                                                                                                                                                                                                                                                     string.isEmpty()).collect(Collectors.toList());
		System.out.println(count);
		System.out.println(filtered);
	}
	
}
