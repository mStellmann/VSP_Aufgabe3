package mware_lib;

import communication.ObjectServer;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * core of the middleware:
 * Maintains a Reference to the NameService
 * Singleton
 */
@SuppressWarnings("unused")
public class ObjectBroker {
    private static boolean isCreated = false;

    private static ObjectBroker objectBroker;
    private static final Logger log = Logger.getLogger(ObjectBroker.class.getName());
    private NameService nameService;

    private ObjectServer objectServer;

    private ObjectBroker(String serviceName, int port, ObjectServer objectServer) throws IOException {
        objectBroker = this;
        isCreated = true;

        this.objectServer = objectServer;
        this.nameService = new NameServiceImpl(serviceName, port, objectServer);
    }

    /**
     * @return an Implementation for a local NameService
     */
    @SuppressWarnings("unused")
    public NameService getNameService() {
        return nameService;
    }

    /**
     * shuts down the process, the OjectBroker is running in
     * terminates process
     */
    @SuppressWarnings("unused")
    public void shutDown() throws IOException {
        nameService.shutdown();
        objectServer.shutdown();
    }

    /**
     * Initializes the ObjectBroker / creates the local NameService
     *
     * @param serviceName hostname or IP of Nameservice
     * @param port        port NameService is listening at
     * @return an ObjectBroker Interface to Nameservice
     */
    @SuppressWarnings("unused")
    public static ObjectBroker init(String serviceName, int port) {
        if (isCreated) {
            return objectBroker;
        } else {
            try {
                ObjectServer objectServer = null;
                int objectServerPort = 49153;
                do {
                    // Can happen, should never.
                    if (objectServerPort > 65535)
                        throw new RuntimeException("No free ports avaiable.");

                    try {
                        objectServer = new ObjectServer(objectServerPort);
                        return new ObjectBroker(serviceName, port, objectServer);
                    } catch (SocketException so) {
                        log.info("Serverport was not avaiable: " + objectServerPort);
                    }
                    objectServerPort++;
                } while (objectServer != null);
                throw new RuntimeException("Failure at creating the ObjectBroker");
            } catch (IOException e) {
                log.log(Level.SEVERE, "Wrong IP or port", e);
                return null;
            }
        }
    }
}

