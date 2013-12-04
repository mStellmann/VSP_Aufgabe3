package mware_lib;

/**
 * TODO JavaDoc
 */
public class Stub {
    private String name;
    private String hostname;
    private int port;

    public Stub(String name, String hostname, int port) {
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

    public Response invokeRemoteMethod(String methodName, Class[] argumentClasses, Object[] arguments) {
        // TODO Request senden -> ObjectOutputStream ; Response empfangen ObjectInputStream
        return null;
    }
}
