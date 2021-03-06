import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

class MyThread extends Thread{

	Socket client;
	
	
	public  MyThread(Socket c) {
		client = c;
	}
	@Override
	public void run() {
			new Thread(new Runnable()
					{
						public void run() {
							try {
								InputStream in;
								in = client.getInputStream();
								InputStreamReader bridge = new InputStreamReader(in);
								BufferedReader breader = new BufferedReader(bridge);
								while(true)
								{
									System.out.println(breader.readLine());
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						};
					}
					).start();
			
			
			
			new Thread(new Runnable()
					{

						@Override
						public void run() {
							try{
								OutputStream out = client.getOutputStream();
								PrintWriter p = new PrintWriter(out,true);
								InputStream in2 = System.in;
								InputStreamReader bridge2 = new InputStreamReader(in2);
								BufferedReader breader2 = new BufferedReader(bridge2);
								while(true)
								{
									String line;
									line = breader2.readLine();
									System.out.println(line);
									p.println(line);
								}
							
							}catch(IOException e)
							{
								e.printStackTrace();
							}
							
						}
				
					}
					).start();
				}
	
	}
