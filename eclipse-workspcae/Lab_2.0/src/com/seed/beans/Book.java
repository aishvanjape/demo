package com.seed.beans;

//TODO:0	Modification required
public class Book extends Product{
	private String authorName;
	private String publication;
	
//	TODO:1	Provide no-argument public constructor
//	TODO:2	Provide getters and setters for all attributes.
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getPublication() {
		return publication;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
}
