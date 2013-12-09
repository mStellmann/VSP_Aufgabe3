package mware_lib;

import communication.ObjectClient;

import java.io.IOException;

/**
 * This Object contains the hostinformations of the method to be invoked.
 */
public class GernericObjectReference {
    private String name;
    private String hostname;
    private int port;

    public GernericObjectReference(String name, String hostname, int port) {
        this.name = name;
        this.hostname = hostname;
        this.port = port;
    }

    @SuppressWarnings("unused")
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public String getHostname() {
        return hostname;
    }

    @SuppressWarnings("unused")
    public int getPort() {
        return port;
    }

    /**
     * Creates the Request-Object and sends it to the Server and receive the Response-Object.
     *
     * @param methodName      Name of the remote method.
     * @param argumentClasses All classes of the methodparameters.
     * @param arguments       All methodparameters.
     * @return The returnvalue of the invoked remote method.
     * @throws RuntimeException If something went wrong.
     */
    public Response invokeRemoteMethod(String methodName, Class[] argumentClasses, Object[] arguments) throws RuntimeException {
        try {
            ObjectClient client = new ObjectClient(hostname, port);
            client.sendObject(new Request(name, methodName, argumentClasses, arguments));
            return (Response) client.receiveObject();

        } catch (IOException e) {
            throw new RuntimeException("Connection Error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not Found ClassNotFoundException");
        }
    }
}
