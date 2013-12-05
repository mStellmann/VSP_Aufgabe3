package communication;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    private BufferedReader in;
    private ObjectInputStream inObj;
    private DataOutputStream out;
    private ObjectOutputStream outObj;

    public Client(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket(host, port);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inObj = new ObjectInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        outObj = new ObjectOutputStream(socket.getOutputStream());
    }

    public String receive() throws IOException {
        return in.readLine();
    }

    public Object receiveObject() throws IOException, ClassNotFoundException {
        return inObj.readObject();
    }

    public void send(String message) throws IOException {
        out.writeBytes(message + '\n');
    }

    public void sendObject(Object o) throws IOException {
        outObj.writeObject(o);
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
