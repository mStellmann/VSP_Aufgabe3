package mware_lib;

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

    public Response invokeRemoteMethod(String classname, String methodName, Class[] argumentClasses, Object[] arguments) throws RuntimeException {
        // TODO Request senden -> ObjectOutputStream ; Response empfangen ObjectInputStream
        return null;
    }
}
