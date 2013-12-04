package communication;

import java.io.*;
import java.net.Socket;

public class Connection {
    private Socket socket;
    private BufferedReader in;
    private DataOutputStream out;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
    }

    public String receive() throws IOException {
        return in.readLine();
    }

    public void send(String message) throws IOException {
        out.writeBytes(message + '\n');
    }

    public String getHostname() {
        return socket.getInetAddress().getHostAddress();
    }

    public int getPort() {
        return socket.getPort();
    }

    public void close() throws IOException {
        in.close();
        out.close();
    }
}
