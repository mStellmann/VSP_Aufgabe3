package communication;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket mySocket;
	private BufferedReader in;
	private DataOutputStream out;
	
	public Client(String host, int port) throws UnknownHostException, IOException {
		mySocket = new Socket(host, port);
		
		in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        out = new DataOutputStream(mySocket.getOutputStream());
	}
	
	public String receive() throws IOException {
		return in.readLine();
	}
	
	public void send(String message) throws IOException {
		out.writeBytes(message + '\n');
	}
	
	public void close() throws IOException {
		in.close();
		out.close();
		mySocket.close();
	}
}
