package mware_lib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: Matthias
 * Date: 05.12.13
 * Time: 14:44
 */
public class Skeleton {
    private final Object object;

    public Skeleton(Object object) {
        this.object = object;
    }

    public Response invokeMethode(String methodName, Class[] argumentClasses, Object[] arguments) {
        try {
            Method method = object.getClass().getMethod(methodName, argumentClasses);
            Object result = method.invoke(object, arguments);
            return new Response(true, result, null);

        } catch (NoSuchMethodException e) {
            return new Response(false, null, new RuntimeException("NoSuchMethodException"));
        } catch (InvocationTargetException e) {
            return new Response(false, null, new RuntimeException("NoSuchMethodException"));
        } catch (IllegalAccessException e) {
            return new Response(false, null, new RuntimeException("NoSuchMethodException"));
        }
    }
}
