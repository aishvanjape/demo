import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client = new Socket("10.102.49.208", 5568);
		System.out.println("Connected to server");
		
		new MyThread(client).start();
		
		
	}
}
