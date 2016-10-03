package com.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class StreamLayering {

	public static void main(String[] args) throws IOException {
		
		
		File file;
		String filename = "abc";
		file = new File(filename);
		if(file.isDirectory())
		{
			System.out.println(file.list().length);
			for(File f:file.listFiles())
			{
				if(f.getName().endsWith(".txt"))
				{
					f.delete();
				}
			}
			
			
			
		}
		else{
			System.out.println("Name"+file.getName());
			System.out.println("Path"+file.getPath());
			System.out.println("Total Space"+file.getTotalSpace());
		}
		
//		String file = "test1.txt";
//		//PrintWriter p = new PrintWriter(file);
//		
//		//p.write("A");
//		
//		FileWriter p = new FileWriter(file);
//		//p.write('a');
//		
//		
//		InputStreamReader input = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(input);
//		
//		String d;
//		d=br.readLine();
//		p.write(d);
//		
//		char c;
//		while((c = (char) br.read())!='\n')
//		{
//			if(Character.isDigit(c))
//			{
//				p.write("*");
//			}
//			else if(Character.isUpperCase(c))
//			{	
//				p.write(Character.toLowerCase(c));
//			}
//			else{p.write(Character.toUpperCase(c));}
//		}
//		
//		//Scanner s = new Scanner(System.in);
//		
//		br.close();
//		p.close();
//		//System.out.println("buffer"+br.readLine());
//		
	}

}