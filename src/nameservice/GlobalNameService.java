package nameservice;

import communication.Connection;
import communication.Server;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Global nameservice
 */
public class GlobalNameService {
    /**
     * Contains every binded object.
     */
    public static Map<String, HostReference> objectMap;

    /**
     * Serverlistenport
     */
    private static final int LISTENPORT = 12345;

    /**
     * Start a NameService-Server
     *
     * @param args Input values.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        objectMap = new HashMap<>();

        Server server = new Server(LISTENPORT);
        // Server never stop running
        while (true) {
            Connection connection = server.getConnection();
            (new GlobalNameServiceThread(connection)).start();
        }
    }

    protected static synchronized void addObjectToMap(String name, HostReference servant) {
        objectMap.put(name, servant);
    }

    protected static synchronized HostReference getObjectFromMap(String name) {
        return objectMap.get(name);
    }
}

/**
 * Working thread to process the client request
 */
class GlobalNameServiceThread extends Thread {
    /**
     * active connection
     */
    private Connection connection;

    /**
     * Logger
     */
    private final Logger log = Logger.getLogger(GlobalNameServiceThread.class.getName());

    /**
     * constructor
     *
     * @param connection active connection to a client
     */
    public GlobalNameServiceThread(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String[] message = (connection.receive()).split(";");
                log.info("receive msg: " + Arrays.toString(message));
                switch (message[0]) {
                    case "REBIND":
                        log.info("RequestMessage added to objectMap");
                        GlobalNameService.addObjectToMap(message[1], new HostReference(message[2], Integer.parseInt(message[3])));
                        connection.send("OK");
                        break;
                    case "RESOLVE":
                        log.info("Sending requested object to client");
                        HostReference requestedHostReference = GlobalNameService.getObjectFromMap(message[1]);
                        connection.send("OK;" + requestedHostReference.getHostname() + ";" + requestedHostReference.getPort());
                        break;
                    default:
                        log.log(Level.SEVERE, "Unknown message received");
                        connection.send("ERROR");
                        break;
                }

            } catch (IOException e) {
                log.log(Level.SEVERE, "Received message problem", e);
                break;
            } catch (NullPointerException e) {
                log.log(Level.SEVERE, "Connection closed", e);
                break;
            }
        }
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();  // TODO Exceptionhandling
        }
    }
}
