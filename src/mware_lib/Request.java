package mware_lib;

import java.io.Serializable;

/**
 * Request-Objects to invoke methods at the server.
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 3951897477047131910L;
    private final String objectRefName;
    private final String methodName;
    private final Object[] arguments;
    private final Class[] argumentClasses;

    public Request(String objectRefName, String methodName, Class[] argumentClasses, Object[] arguments) {
        this.objectRefName = objectRefName;
        this.methodName = methodName;
        this.arguments = arguments;
        this.argumentClasses = argumentClasses;
    }

    public String getObjectRefName() {
        return objectRefName;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Class[] getArgumentClasses() {  return argumentClasses; }
}
