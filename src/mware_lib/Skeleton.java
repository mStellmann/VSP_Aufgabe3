package mware_lib;

import bank_access.AccountImplBase;
import bank_access.ManagerImplBase;
import cash_access.InvalidParamException;
import cash_access.OverdraftException;
import cash_access.TransactionImplBase;

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
//    public Response invokeMethod(String methodName, Class[] argumentClasses, Object[] arguments) {
//        try {
//            System.out.println("--- invoke on Server ---");
//            Method method = servant.getClass().getMethod(methodName, argumentClasses);
//            Object result = method.invoke(servant, arguments);
//            return new Response(true, result, null);
//
//        } catch (NoSuchMethodException e) {
//            return new Response(false, null, new RuntimeException("NoSuchMethodException"));
//        } catch (InvocationTargetException e) {
//            return new Response(false, null, new RuntimeException("InvocationTargetException"));
//        } catch (IllegalAccessException e) {
//            return new Response(false, null, new RuntimeException("IllegalAccessException"));
//        }
//    }
    public Response invokeMethod(String methodName, Class[] argumentClasses, Object[] arguments) {
        Object result = null;
        boolean isCorrect = true;
        RuntimeException exception = null;
        if (servant instanceof AccountImplBase) {
            switch (methodName) {
                case "transfer":
                    try {
                        ((AccountImplBase) servant).transfer((double) arguments[0]);
                    } catch (Exception e) {
                        exception = new RuntimeException(e.getMessage());
                        isCorrect = false;
                    }
                    break;
                case "getBalance":
                    result = ((AccountImplBase) servant).getBalance();
                    break;
                default:
                    exception = new RuntimeException("NoSuchMethodFound");
                    isCorrect = false;
                    break;
            }
        } else if (servant instanceof ManagerImplBase) {
            switch (methodName) {
                case "createAccount":
                    result = ((ManagerImplBase) servant).createAccount((String) arguments[0], (String) arguments[1]);
                    break;
                default:
                    exception = new RuntimeException("NoSuchMethodFound");
                    isCorrect = false;
                    break;
            }
        } else if (servant instanceof TransactionImplBase) {
            switch (methodName) {
                case "deposit":
                    try {
                        ((TransactionImplBase) servant).deposit((String) arguments[0], (double) arguments[1]);
                    } catch (InvalidParamException e) {
                        exception = new RuntimeException(e.getMessage());
                        isCorrect = false;
                    }
                    break;
                case "withdraw":
                    try {
                        ((TransactionImplBase) servant).withdraw((String) arguments[0], (double) arguments[1]);
                    } catch (InvalidParamException e) {
                        exception = new RuntimeException(e.getMessage());
                        isCorrect = false;
                    } catch (OverdraftException e) {
                        exception = new RuntimeException(e.getMessage());
                        isCorrect = false;
                    }
                    break;
                case "getBalance":
                    try {
                        ((TransactionImplBase) servant).getBalance((String) arguments[0]);
                    } catch (InvalidParamException e) {
                        exception = new RuntimeException(e.getMessage());
                        isCorrect = false;
                    }
                    break;
                default:
                    exception = new RuntimeException("NoSuchMethodFound");
                    isCorrect = false;
                    break;
            }
        } else {
            exception = new RuntimeException("NoSuchClassFound");
            isCorrect = false;
        }
        return new Response(isCorrect, result, exception);
    }

}
