package mware_lib;

import communication.Client;

import java.io.IOException;

class NameServiceImpl extends NameService {

    private Client client;

    public NameServiceImpl(String serviceName, int port) throws IOException {
        this.client = new Client(serviceName, port);
    }

    @Override
    public void rebind(Object servant, String name) throws IOException {
        client.send("REBIND," + servant + "," + name);
    }

    @Override
    public Object resolve(String name) throws IOException {
        client.send("RESOLVE,null," + name);
        return client.receive();
    }

    @Override
    public void shutdown() throws IOException {
        client.close();
    }
}
