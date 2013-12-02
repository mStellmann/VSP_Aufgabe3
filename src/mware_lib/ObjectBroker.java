package mware_lib;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * core of the middleware:
 * Maintains a Reference to the NameService
 * Singleton
 */
public class ObjectBroker {
    private static boolean isCreated = false;
    private static ObjectBroker objectBroker;
    private static final Logger log = Logger.getLogger(ObjectBroker.class.getName());

    private NameService nameService;

    private ObjectBroker(String serviceName, int port) throws IOException {
        this.isCreated = true;
        this.objectBroker = this;

        this.nameService = new NameServiceImpl(serviceName, port);
    }

    /**
     * @return an Implementation for a local NameService
     */
    public NameService getNameService() {
        return nameService;
    }

    /**
     * shuts down the process, the OjectBroker is running in
     * terminates process
     */
    public void shutdown() throws IOException {
        nameService.shutdown();
    }

    /**
     * Initializes the ObjectBroker / creates the local NameService
     *
     * @param serviceName hostname or IP of Nameservice
     * @param port        port NameService is listening at
     * @return an ObjectBroker Interface to Nameservice
     */
    public static ObjectBroker init(String serviceName, int port) {
        if (isCreated) {
            return objectBroker;
        } else {
            try {
                return new ObjectBroker(serviceName, port);
            } catch (IOException e) {
                log.log(Level.SEVERE, "Wrong IP or port", e);
                return null;
            }
        }
    }
}

