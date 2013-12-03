package communication;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	private ServerSocket MySvrSocket;
	
	public Server(int listenPort) throws IOException {
		MySvrSocket = new ServerSocket(listenPort);		
	}
	
	public Connection getConnection() throws IOException {
		return new Connection(MySvrSocket.accept());
	}
	
	public void shutdown() throws IOException {
		MySvrSocket.close();
	}

}
