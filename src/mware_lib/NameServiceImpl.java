package mware_lib;

import communication.Client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class NameServiceImpl extends NameService {

    private Client client;
    private Map<String, Object> skeletonMap;

    public NameServiceImpl(String serviceName, int port) throws IOException {
        this.client = new Client(serviceName, port);
        skeletonMap = new HashMap<>();
    }

    @Override
    public void rebind(Object servant, String name) throws IOException {
        client.send("REBIND," + name);
        skeletonMap.put(name, servant);
    }

    @Override
    public Object resolve(String name) throws IOException {
        client.send("RESOLVE," + name);
        // elem 0: hostname ; elem 1: port
        String[] resolveAnswer = client.receive().split(",");
        return new GernericObjectReference(name, resolveAnswer[0], Integer.getInteger(resolveAnswer[1]));
    }

    @Override
    public void shutdown() throws IOException {
        client.close();
    }
}
