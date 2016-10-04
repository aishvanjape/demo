import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("10.102.49.208", 5568);
		System.out.println("Connected to server");
		
		
		InputStream in = client.getInputStream();
		InputStreamReader bridge = new InputStreamReader(in);
		BufferedReader breader = new BufferedReader(bridge);
		OutputStream out = client.getOutputStream();
		PrintWriter p = new PrintWriter(out,true);
		InputStream in2 = System.in;
		InputStreamReader bridge2 = new InputStreamReader(in2);
		BufferedReader breader2 = new BufferedReader(bridge2);
		while(true)
		{
			String s;
			s= breader2.readLine();
			System.out.println("You :"+s);
			p.println(s);
			System.out.println("Server :"+breader.readLine());
		}
	}
}
