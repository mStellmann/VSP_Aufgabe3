package mware_lib;

import communication.ObjectConnection;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This Thread handles the incoming method request.
 */
public class ObjectServerThread extends Thread {
    private ObjectConnection connection;

    private static final Logger log = Logger.getLogger(ObjectServerThread.class.getName());
    // Reference to the skeletonMap
    private Map<String, Skeleton> skeletonMap;

    public ObjectServerThread(ObjectConnection connection, Map<String, Skeleton> skeletonMap) {
        this.connection = connection;
        this.skeletonMap = skeletonMap;
    }

    @Override
    public void run() {
//        while (true)
        try {
            Object requestObject = connection.receiveObject();
            log.info("Received Object");
            if (requestObject instanceof Request) {
                Request request = (Request) requestObject;
                Skeleton skeleton = skeletonMap.get(request.getObjectRefName());
                Response response = skeleton.invokeMethod(request.getMethodName(), request.getArguments());
                connection.sendObject(response);
            } else {
                connection.sendObject(new Response(false, null, new RuntimeException("Received an unknown object")));
            }

        } catch (IOException e) {
            log.log(Level.SEVERE, "IOException", e);
        } catch (ClassNotFoundException e) {
            log.log(Level.SEVERE, "ClassNotFoundException", e);
        }
    }
}
