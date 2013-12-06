package mware_lib;

import communication.ObjectConnection;

import java.io.IOException;
import java.util.Map;

/**
 * This Thread handles the incoming method request.
 */
public class ObjectServerThread extends Thread {
    ObjectConnection connection;

    // Reference to the skeletonMap
    Map<String, Skeleton> skeletonMap;

    public ObjectServerThread(ObjectConnection connection, Map<String, Skeleton> skeletonMap) {
        this.connection = connection;
        this.skeletonMap = skeletonMap;
    }

    @Override
    public void run() {
        try {
            Object requestObject = connection.receiveObject();
            if (requestObject instanceof Request) {
                Request request = (Request) requestObject;
                Skeleton skeleton = skeletonMap.get(request.getObjectRefName());
                Response response = skeleton.invokeMethod(request.getMethodName(), request.getArgumentClasses(), request.getArguments());
                connection.sendObject(response);
            } else {
                connection.sendObject(new Response(false, null, new RuntimeException("Received an unknown object")));
            }

        } catch (IOException e) {
            e.printStackTrace(); // TODO logging
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // TODO logging
        }
    }
}
