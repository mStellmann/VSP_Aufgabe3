package mware_lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Skeleton-Object to invoke methods on an object.
 */
public class Skeleton {
    private final Object object;

    public Skeleton(Object object) {
        this.object = object;
    }

    /**
     * Invokes a method on the object.
     *
     * @param methodName      Methodename of the methode to be invoked.
     * @param argumentClasses Classes of the arguments of the invoked method.
     * @param arguments       Arguments of the invoked method.
     * @return Response-Object with the result of the invoked method.
     */
    public Response invokeMethode(String methodName, Class[] argumentClasses, Object[] arguments) {
        try {
            Method method = object.getClass().getMethod(methodName, argumentClasses);
            Object result = method.invoke(object, arguments);
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
