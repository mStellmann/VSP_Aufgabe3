package communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket MySocket;
	private BufferedReader In;
	private OutputStream Out;

	public Client(String host, int port) throws UnknownHostException, IOException {
		MySocket = new Socket(host, port);

		In = new BufferedReader(new InputStreamReader(MySocket.getInputStream()));
		Out = MySocket.getOutputStream();
	}

	public String receive() throws IOException {
		return In.readLine();
	}

	public void send(String message) throws IOException {
		Out.write((message + "\n").getBytes());
	}

	public void close() throws IOException {
		In.close();
		Out.close();
		MySocket.close();
	}
}
