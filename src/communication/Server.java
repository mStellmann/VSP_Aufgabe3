package communication;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;

    public Server(int listenPort) throws IOException {
        serverSocket = new ServerSocket(listenPort);
    }

    public Connection getConnection() throws IOException {
        return new Connection(serverSocket.accept());
    }

    public void shutdown() throws IOException {
        serverSocket.close();
    }

    public String getHostname() {
        return serverSocket.getInetAddress().getHostName();
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

}
