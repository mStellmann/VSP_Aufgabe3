package communication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Response Class for the Request/Response protocol between Server and Client
 */
public class Response {

    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(Response.class.getName());

    /**
     * Static method used to send a response to the client
     *
     * @param objectName   Name of the remote object
     * @param objectMethod Name of the method of the remote object
     * @param methodParams The parameters for the method
     */
    public static void send(String objectName, String objectMethod, String... methodParams) {

        try {
            Connection connection = comInit();
            Message message = new Message("RESPONSE", objectName, objectMethod, methodParams, "SUCCESS");
            connection.send(message.toString());
        } catch (IOException e) {
            log.log(Level.SEVERE, "IOException - Response - send()", e);
        }

    }

    /**
     * Static method used to receive a message from the Client
     *
     * @return Message
     */
    public static Message receive() {
        try {
            Connection connection = comInit();
            String messageString = connection.receive();
            String[] stringAry = messageString.split(",");
            List<String> proxyList = new ArrayList<String>();
            for (int i = 3; i < stringAry.length - 1; i++) {
                proxyList.add(stringAry[i]);
            }
            String[] methodStringAry = proxyList.toArray(new String[proxyList.size()]);
            return new Message(stringAry[0], stringAry[1], stringAry[2], methodStringAry, stringAry[4]);

        } catch (IOException e) {
            log.log(Level.SEVERE, "IOException - Response - receive()", e);
            return null;
        }

    }

    /**
     * Private static method used to initialize the connection between the Server and the client
     *
     * @return Connection
     * @throws IOException
     */
    private static Connection comInit() throws IOException {
        Server theServer = new Server(14001);
        // Auf Verbindungsanfrage warten.
        return theServer.getConnection();
    }
}
