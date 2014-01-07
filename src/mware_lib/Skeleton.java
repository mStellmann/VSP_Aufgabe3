package mware_lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Skeleton-Object to invoke methods on an servant.
 */
public class Skeleton {
    private final Object servant;

    public Skeleton(Object servant) {
        this.servant = servant;
    }

    /**
     * Invokes a method on the servant.
     *
     * @param methodName      Methodename of the methode to be invoked.
     * @param argumentClasses Classes of the arguments of the invoked method.
     * @param arguments       Arguments of the invoked method.
     * @return Response-Object with the result of the invoked method.
     */
    public Response invokeMethod(String methodName, Class[] argumentClasses, Object[] arguments) {
        try {
            System.out.println("--- invoke on Server ---");
            Method method = servant.getClass().getMethod(methodName, argumentClasses);
            Object result = method.invoke(servant, arguments);
            return new Response(true, result, null);

        } catch (NoSuchMethodException e) {
            return new Response(false, null, new RuntimeException("NoSuchMethodException"));
        } catch (InvocationTargetException e) {
            return new Response(false, null, new RuntimeException("InvocationTargetException"));
        } catch (IllegalAccessException e) {
            return new Response(false, null, new RuntimeException("IllegalAccessException"));
        }
    }
}
