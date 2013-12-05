package communication;

import java.io.IOException;
import java.net.ServerSocket;

public class ObjectServer {
    private ServerSocket MySvrSocket;

    public ObjectServer(int listenPort) throws IOException {
        MySvrSocket = new ServerSocket(listenPort);
    }

    public ObjectConnection getConnection() throws IOException {
        return new ObjectConnection(MySvrSocket.accept());
    }

    public void shutdown() throws IOException {
        MySvrSocket.close();
    }

    public String getHostname() {
        return MySvrSocket.getInetAddress().getHostName();
    }

    public int getPort() {
        return MySvrSocket.getLocalPort();
    }

}
