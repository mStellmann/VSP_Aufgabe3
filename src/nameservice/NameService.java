package nameservice;

import communication.Connection;
import communication.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Global nameservice
 */
public class NameService {
    /**
     * Contains every binded object.
     */
    private static Map<String, Object> objectMap;

    /**
     * Serverlistenport
     */
    private static final int LISTENPORT = 14001;

    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(NameService.class.getName());

    /**
     * Start a NameService-Server
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        objectMap = new HashMap<String, Object>();

        Server server = new Server(LISTENPORT);
        while (true) {
            Connection connection = server.getConnection();
            (new NameServiceThread(connection)).start();
        }
    }

    protected static synchronized void addObjectToMap(String name, Object servant) {
        objectMap.put(name, servant);
    }

    protected static synchronized Object getObjectFromMap(String name) {
        return objectMap.get(name);
    }
}

/**
 * Working thread to process the client request
 */
class NameServiceThread extends Thread {
    /**
     * active connection
     */
    private Connection connection;

    /**
     * Logger
     */
    private final Logger log = Logger.getLogger(NameServiceThread.class.getName());

    /**
     * constructor
     *
     * @param connection active connection to a client
     */
    public NameServiceThread(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            String[] message = ((String) connection.receive()).split(",");

            switch (message[0]) {
                case "REBIND":
                    connection.send("OK");
                    Object objectToSave = connection.receive();
                    log.info("RequestMessage added to objectMap");
                    NameService.addObjectToMap(message[1], objectToSave);
                    connection.close();
                    break;
                case "RESOLVE":
                    log.info("Sending requested object to client");
                    Object requestedObject = NameService.getObjectFromMap(message[1]);
//                    connection.send(requestedObject);
                    System.out.println("WAAHHAHA");
                    connection.close();
                    break;
                default:
                    log.log(Level.SEVERE, "Unknown message received");
                    connection.close();
                    break;
            }

        } catch (IOException e) {
            log.log(Level.SEVERE, "Received message problem", e);
        }
    }
}
