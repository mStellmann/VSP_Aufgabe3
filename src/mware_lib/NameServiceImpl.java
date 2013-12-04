package mware_lib;

import communication.Client;

import java.io.IOException;
import java.io.Serializable;

class NameServiceImpl extends NameService {

    private Client client;

    public NameServiceImpl(String serviceName, int port) throws IOException {
        this.client = new Client(serviceName, port);
    }

    @Override
    public void rebind(Object servant, String name) throws IOException, ClassNotFoundException {
        client.send("REBIND," + name);
    }

    @Override
    public Object resolve(String name) throws IOException, ClassNotFoundException {
        client.send("RESOLVE," + name);
        // elem 0: hostname ; elem 1: port
        String[] resolveAnswer = client.receive().split(",");
        return new Stub(name, resolveAnswer[0], Integer.getInteger(resolveAnswer[1]));
    }

    @Override
    public void shutdown() throws IOException {
        client.close();
    }
}
