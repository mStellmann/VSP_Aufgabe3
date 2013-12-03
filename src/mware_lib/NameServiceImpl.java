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
        if (client.receive().equals("OK")) {
            System.out.println("HAHHAHAHAHAHAHAHAHH");
        }
    }

    @Override
    public Object resolve(String name) throws IOException, ClassNotFoundException {
        client.send("RESOLVE," + name);
        return client.receive();
    }

    @Override
    public void shutdown() throws IOException {
        client.close();
    }
}
