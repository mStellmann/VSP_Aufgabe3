package communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    private BufferedReader in;
    private DataOutputStream out;

    public Client(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket(host, port);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
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
        socket.close();
    }
}
