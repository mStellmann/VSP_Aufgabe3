package mware_lib;

import communication.Connection;

import java.util.Map;

/**
 * TODO JavaDoc
 */
public class ObjectServerThread extends Thread {
    Connection connection;

    // Reference to the skeletonMap
    Map<String, Object> skeletonMap;

    public ObjectServerThread(Connection connection, Map<String, Object> skeletonMap) {
        this.connection = connection;
        this.skeletonMap = skeletonMap;
    }

    @Override
    public void run() {
        super.run();    // TODO
    }
}
