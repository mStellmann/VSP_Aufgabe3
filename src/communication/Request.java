package communication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 02.12.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
public class Request {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(Response.class.getName());

    /**
     * Static method used to send a response to the client
     *
     * @param objectName   Name of the remote object
     * @param objectMethod Name of the method of the remote object
     * @param methodParams The parameters for the method
     */
    public static void send(Connection connection,String objectName, String objectMethod, Object... methodParams) {

        try {
            RequestMessage message = new RequestMessage("REQUEST", objectName, objectMethod, methodParams, "SUCCESS");
            connection.send(message.toString());
        } catch (IOException e) {
            log.log(Level.SEVERE, "IOException - Response - send()", e);
        }

    }
}
