package mware_lib;

import java.io.Serializable;

/**
 * Response-Object with the returnvalue or an exception.
 */
public class Response implements Serializable {
    private static final long serialVersionUID = -2895253895746900973L;
    private final boolean isCorrect;
    private final Object returnValue;
    private final RuntimeException exception;

    public Response(boolean isCorrect, Object returnValue, RuntimeException exception) {
        this.isCorrect = isCorrect;
        this.returnValue = returnValue;
        this.exception = exception;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public Object getReturnValue() {
        return returnValue;
    }

    public RuntimeException getException() {
        return exception;
    }
}
