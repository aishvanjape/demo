package com.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyService {

	
	public static void main(String[] args) throws IOException {
		int port = 5555;
		
		ServerSocket service = new ServerSocket(port);
		System.out.println("Waiting for connection");
		Socket clientinfo = service.accept();
		
		System.out.println(clientinfo);
		
		InputStream in = clientinfo.getInputStream();
		InputStreamReader bridge = new InputStreamReader(in);
		BufferedReader breader = new BufferedReader(bridge);
		
		OutputStream out = clientinfo.getOutputStream();
		OutputStreamWriter brid = new OutputStreamWriter(out);
		BufferedWriter br = new BufferedWriter(brid);
		
		PrintWriter p = new PrintWriter(out,true);
		
//		while(true)
//		{
//			String line = breader.readLine();
//			
//			if(line == null){
//				br.write("Hello");
//				
//				break;}
//			System.out.println(line);
//		}
		String line;
		while((line=breader.readLine()).length()!=0)
		{
			System.out.println(line);
		}
//		p.println("Hello....HI");
		br.write("Hello..!!...");
		//p.write("Hello World");
//		p.close();
		br.close();
		clientinfo.close();
		service.close();
	}
	
}
