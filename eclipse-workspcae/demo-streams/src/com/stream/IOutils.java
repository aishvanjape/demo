package com.stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOutils {

	
	public static void writePrimitives(OutputStream out) throws IOException
	{
		//TODO Write a long,double and boolean
		
		try(DataOutputStream dOut = new DataOutputStream(out))
		{
			byte[] b = new byte[5];
			b[0]=127;b[1]=-128;
			dOut.writeLong(1L);
			dOut.writeDouble(12.34);
			dOut.writeBoolean(false);
			out.write(256);
			out.write(b);
			
		}
		
	}
	
	
	public static void readPrimitives(InputStream in) throws IOException
	{
		
		try(DataInputStream dIn = new DataInputStream(in))
		{
			byte[] c= new byte[5];
			long value = dIn.readLong();
			System.out.println(value);
			double d = dIn.readDouble();
			System.out.println(d);
			boolean b = dIn.readBoolean();
			System.out.println(b);
			System.out.println(in.read());
			System.out.println(in.read(c));
			System.out.println(c[0]+c[1]);
			
		}
		
		
		
	}
	
}
