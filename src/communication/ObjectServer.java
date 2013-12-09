package communication;

import java.io.IOException;
import java.net.ServerSocket;

public class ObjectServer {
    private ServerSocket serverSocket;

    public ObjectServer(int listenPort) throws IOException {
        serverSocket = new ServerSocket(listenPort);
    }

    public ObjectConnection getConnection() throws IOException {
        return new ObjectConnection(serverSocket.accept());
    }

    public void shutdown() throws IOException {
        serverSocket.close();
    }

    public String getHostname() {
        return "localhost"; // TODO wtf iph
//        return serverSocket.getInetAddress().getHostName();
    }

    public int getPort() {
        return serverSocket.getLocalPort();
    }

}
