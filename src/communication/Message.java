package communication;

/**
 * Message class for Request/Response protocol
 * User: Matthias Stellmann  Grzegorz Markiewicz
 * Date: 02.12.13
 * Time: 13:42
 */
public class Message {

    private String type;
    private String objectName;
    private String objectMethod;
    private String[] methodParams;
    private String status;

    /**
     * @param type
     * @param objectName
     * @param objectMethod
     * @param methodParams
     * @param status
     */
    public Message(String type, String objectName, String objectMethod, String[] methodParams, String status) {
        this.type = type;
        this.objectName = objectName;
        this.objectMethod = objectMethod;
        this.methodParams = methodParams;
        this.status = status;
    }

    /**
     * Getter
     */
    public String getType() {
        return type;
    }

    /**
     * Getter
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * Getter
     */
    public String getObjectMethod() {
        return objectMethod;
    }

    /**
     * Getter
     */
    public String[] getMethodParams() {
        return methodParams;
    }

    /**
     * Getter
     */
    public String getStatus() {
        return status;
    }

    /**
     * Method returning the String for the TCP communication
     *
     * @return String
     */
    public String toString() {
        String methodParamsToString = "";
        for (int i = 0; i < methodParams.length; i++) {
            methodParamsToString = methodParamsToString + methodParams[i] + ",";
        }
        return type + "," + objectName + "," + objectMethod + "," + methodParamsToString + status;
    }
}
