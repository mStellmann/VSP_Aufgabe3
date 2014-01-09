package bank_access;

import mware_lib.GernericObjectReference;
import mware_lib.Response;

/**
 * Stub-Object of the given Interface.
 */
public class AccountStub extends AccountImplBase {

    private GernericObjectReference gernericObjectReference;

    public AccountStub(GernericObjectReference gernericObjectReference) {
        this.gernericObjectReference = gernericObjectReference;
    }

    @Override
    public void transfer(double amount) throws RuntimeException {
        Response response = gernericObjectReference.invokeRemoteMethod("transfer", new Object[]{amount});

        if (!response.isCorrect())
            throw response.getException();
    }

    @Override
    public double getBalance() {
        Response response = gernericObjectReference.invokeRemoteMethod("getBalance", new Object[]{});

        if (!response.isCorrect())
            throw response.getException();
        else
            return (double) response.getReturnValue();
    }
}
