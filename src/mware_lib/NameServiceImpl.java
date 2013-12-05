package mware_lib;

import communication.Client;
import communication.Connection;
import communication.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class NameServiceImpl extends NameService {

    private Client client;
    private Server objectServer;
    private boolean objectServerIsRunning;
    private Thread serverThread;
    private static final Logger log = Logger.getLogger(NameServiceImpl.class.getName());
    private Map<String, Skeleton> skeletonMap;

    public NameServiceImpl(String serviceName, int port, Server objectServer) throws IOException {
        this.client = new Client(serviceName, port);
        this.objectServer = objectServer;
        objectServerIsRunning = false;
        skeletonMap = new HashMap<>();
    }

    @Override
    public void rebind(Object servant, String name) throws IOException, RuntimeException {
        client.send("REBIND;" + name + ";" + objectServer.getHostname() + ";" + objectServer.getPort());
        if (client.receive().equals("OK")) {
            // saving the object as skeleton
            skeletonMap.put(name, new Skeleton(servant));

            // starting the object server if no instance is running
            if (!objectServerIsRunning) {
                objectServerIsRunning = true;

                serverThread = new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            if (this.isInterrupted()) {
                                this.interrupt();
                            }
                            try {
                                Connection connection = objectServer.getConnection();
                                (new ObjectServerThread(connection, skeletonMap)).start();
                            } catch (IOException e) {
                                log.log(Level.SEVERE, "connection error", e);
                            }
                        }
                    }
                };
                serverThread.start();
            }
        } else {
            throw new RuntimeException("Rebind Error");
        }

    }

    @Override
    public Object resolve(String name) throws IOException {
        client.send("RESOLVE;" + name);
        // elem 0: hostname ; elem 1: port
        String[] resolveAnswer = client.receive().split(";");
        if (resolveAnswer[0].equals("OK"))
            return new GernericObjectReference(name, resolveAnswer[1], Integer.getInteger(resolveAnswer[2]));
        else
            throw new RuntimeException("Error at resolve");
    }

    @Override
    public void shutdown() throws IOException {
        if (objectServerIsRunning)
            serverThread.interrupt();
        client.close();
    }
}
