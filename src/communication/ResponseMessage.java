package communication;

/**
 * TODO Javadoc
 * User: Matthias Stellmann & Grzegorz Markiewicz
 * Date: 02.12.13
 * Time: 15:48
 */
public class ResponseMessage {
    private String type;
    private String objectName;
    private String objectMethod;
    private Object returnValue;
    private String status;

    /**
     * @param type
     * @param objectName
     * @param objectMethod
     * @param returnValue
     * @param status
     */
    public ResponseMessage(String type, String objectName, String objectMethod, Object returnValue, String status) {
        this.type = type;
        this.objectName = objectName;
        this.objectMethod = objectMethod;
        this.returnValue = returnValue;
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
    public Object getReturnValue() {
        return returnValue;
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

        return type + "," + objectName + "," + objectMethod + "," + returnValue.toString()+ "," + status;
    }
}
