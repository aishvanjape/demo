package com.stream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Entry {

	public static void main(String[] args) throws IOException {
		
		String fileName = "test.txt";
		try (FileOutputStream fOut = new FileOutputStream(fileName))
		{
			IOutils.writePrimitives(fOut);
		} 
		
		try (FileInputStream fIn = new FileInputStream(fileName))
		{
			IOutils.readPrimitives(fIn);
		}
		
		
	}
	
}
