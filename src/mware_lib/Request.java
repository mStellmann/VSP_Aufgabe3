package mware_lib;

import java.io.Serializable;

/**
 * Request-Objects to invoke methods at the server.
 */
public class Request implements Serializable {
    private static final long serialVersionUID = 3951897477047131910L;
    private final String classname;
    private final String methodName;
    private final Class[] argumentClasses;
    private final Object[] arguments;

    public Request(String classname, String methodName, Class[] argumentClasses, Object[] arguments) {
        this.classname = classname;
        this.methodName = methodName;
        this.argumentClasses = argumentClasses;
        this.arguments = arguments;
    }

    public String getClassname() {
        return classname;
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
