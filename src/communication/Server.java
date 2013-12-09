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

    @SuppressWarnings("unused")
    public void shutdown() throws IOException {
        serverSocket.close();
    }

    @SuppressWarnings("unused")
    public String getHostname() {
        return serverSocket.getInetAddress().getHostName();
    }

    @SuppressWarnings("unused")
    public int getPort() {
        return serverSocket.getLocalPort();
    }

}
