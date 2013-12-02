package communication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Response Class for the Request/Response protocol between Server and Client
 */
public class Response {

    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(Response.class.getName());

    public static void sendSuccess(Connection connection, String objectName, String objectMethod, Object returnValue) {
        send(connection, objectName, objectMethod, returnValue, "SUCCESS");
    }

    public static void sendError(Connection connection, String objectName, String objectMethod, Object returnValue) {
        send(connection, objectName, objectMethod, returnValue, "ERROR");
    }

    /**
     * Static method used to send a response to the client
     *
     * @param objectName   Name of the remote object
     * @param objectMethod Name of the method of the remote object
     * @param returnValue  The parameters for the method
     */
    private static void send(Connection connection, String objectName, String objectMethod, Object returnValue, String status) {

        try {

            ResponseMessage message = new ResponseMessage("RESPONSE", objectName, objectMethod, returnValue, status);
            connection.send(message.toString());
        } catch (IOException e) {
            log.log(Level.SEVERE, "IOException - Response - send()", e);
        }

    }

//    /**
//     * Static method used to receive a message from the Client
//     *
//     * @return RequestMessage
//     */
//    public static RequestMessage receive(Connection connection) {
//        try {
//            String messageString = connection.receive();
//            String[] stringAry = messageString.split(",");
//            List<String> proxyList = new ArrayList<String>();
//            for (int i = 3; i < stringAry.length - 1; i++) {
//                proxyList.add(stringAry[i]);
//            }
//            String[] methodStringAry = proxyList.toArray(new String[proxyList.size()]);
//            return new RequestMessage(stringAry[0], stringAry[1], stringAry[2], methodStringAry, stringAry[4]);
//
//        } catch (IOException e) {
//            log.log(Level.SEVERE, "IOException - Response - receive()", e);
//            return null;
//        }
//
//    }


}
