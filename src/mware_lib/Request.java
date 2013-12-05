package mware_lib;

import java.io.Serializable;

/**
 * Request-Objects to invoke methods at the server.
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 3951897477047131910L;
    private final String objectRefName;
    private final String methodName;
    private final Class[] argumentClasses;
    private final Object[] arguments;

    public Request(String objectRefName, String methodName, Class[] argumentClasses, Object[] arguments) {
        this.objectRefName = objectRefName;
        this.methodName = methodName;
        this.argumentClasses = argumentClasses;
        this.arguments = arguments;

    }

    public String getObjectRefName() {
        return objectRefName;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class[] getArgumentClasses() {
        return argumentClasses;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
