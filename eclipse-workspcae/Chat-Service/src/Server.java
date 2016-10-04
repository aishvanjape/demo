import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{
	public static void main(String[] args) throws IOException {
		int port= 5568;
		ServerSocket server = new ServerSocket(port);
		while(true)
		{
		System.out.println("waiting for connection");
		Socket client = server.accept();
		System.out.println("Connection accepted");
		MyThread client1 = new MyThread(client);
		client1.start();
		}
		//client.close();
		//server.close();
	}

	
}

