package nameservice;

/**
 * Reference-Object to locate saved server.
 */
public class HostReference {
    private String hostname;
    private int port;

    public HostReference(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "HostReference{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                '}';
    }
}
