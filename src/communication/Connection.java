package communication;

import java.io.*;
import java.net.Socket;

public class Connection {
    private BufferedReader in;
    private ObjectInputStream inObject;
    private DataOutputStream out;

    public Connection(Socket mySock) throws IOException {
        in = new BufferedReader(new InputStreamReader(mySock.getInputStream()));
        out = new DataOutputStream(mySock.getOutputStream());
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
    }
}
