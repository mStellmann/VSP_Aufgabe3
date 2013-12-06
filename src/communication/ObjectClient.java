package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObjectClient {
    private Socket socket;

    private ObjectInputStream inObj;
    private ObjectOutputStream outObj;

    public ObjectClient(String host, int port) throws UnknownHostException, IOException {
        socket = new Socket(host, port);

        inObj = new ObjectInputStream(socket.getInputStream());
        outObj = new ObjectOutputStream(socket.getOutputStream());
    }

    public Object receiveObject() throws IOException, ClassNotFoundException {
        return inObj.readObject();
    }

    public void sendObject(Object o) throws IOException {
        outObj.writeObject(o);
    }

    public void close() throws IOException {
        inObj.close();
        outObj.close();
        socket.close();
    }
}
