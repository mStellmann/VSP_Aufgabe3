package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectConnection {
    private ObjectInputStream inObj;
    private ObjectOutputStream outObj;

    public ObjectConnection(Socket socket) throws IOException {
        inObj = new ObjectInputStream(socket.getInputStream());
        outObj = new ObjectOutputStream(socket.getOutputStream());
    }

    public Object receiveObject() throws IOException, ClassNotFoundException {
        return inObj.readObject();
    }

    public void sendObject(Object o) throws IOException {
        outObj.writeObject(o);
    }

    @SuppressWarnings("unused")
    public void close() throws IOException {
        inObj.close();
        outObj.close();
    }
}
