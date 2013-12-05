package mware_lib;

import communication.Client;

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

    public Response invokeRemoteMethod(String methodName, Class[] argumentClasses, Object[] arguments) throws RuntimeException {
        try {
            Client client = new Client(hostname, port);
            client.sendObject(new Request(name, methodName, argumentClasses, arguments));
            return (Response) client.receiveObject();

        } catch (IOException e) {
            throw new RuntimeException("Connection Error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not Found ClassNotFoundException");
        }
    }
}
