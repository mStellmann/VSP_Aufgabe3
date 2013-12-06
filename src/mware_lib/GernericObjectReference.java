package mware_lib;

import communication.ObjectClient;

import java.io.IOException;

/**
 * TODO JavaDoc
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

    public String getName() {
        return name;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    /**
     * TODO JavaDoc
     *
     * @param methodName
     * @param argumentClasses
     * @param arguments
     * @return
     * @throws RuntimeException
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
