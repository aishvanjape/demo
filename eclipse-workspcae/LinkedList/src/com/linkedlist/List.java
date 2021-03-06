package com.linkedlist;

public class List {

	private Node head;
	private Node last;
	
	public List() {
		head = null;
		last = null;
	}
	
	private class Node{
		private int data;
		Node link;
		private Node(int d) {
			this.data = d;
			this.link = null;
		}
	}
	
	public void add(int d)
	{
		if(head == null)
		{
			head = new Node(d);
			last = head;
		}
		else{
			/*
			Node temp;
			temp = this.head;
			while(temp.link != null)
			{
				temp = temp.link;
			}
			Node n = new Node(d);
			temp.link = n;
			*/
			Node n = new Node(d);
			last.link = n;
			last = n;
		}
	}
	
	public void display()
	{
		Node temp;
		temp = head;
		while(temp != null)
		{
			System.out.println("Node : "+temp.data);
			temp = temp.link;
		}
	}
	
}
