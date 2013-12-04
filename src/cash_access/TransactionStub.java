package cash_access;

import mware_lib.GernericObjectReference;
import mware_lib.Response;

/**
 * TODO Javadoc
 */
public class TransactionStub extends TransactionImplBase {

    private GernericObjectReference gernericObjectReference;

    public TransactionStub(GernericObjectReference gernericObjectReference) {
        this.gernericObjectReference = gernericObjectReference;
    }

    @Override
    public void deposit(String accountId, double amount) throws InvalidParamException {
        Response response = gernericObjectReference.invokeRemoteMethod("createAccount", new Class[]{String.class, double.class}, new Object[]{accountId, amount});

        if (!response.isCorrect())
            throw response.getException();
    }

    @Override
    public void withdraw(String accountId, double amount) throws InvalidParamException, OverdraftException {
        Response response = gernericObjectReference.invokeRemoteMethod("createAccount", new Class[]{String.class, double.class}, new Object[]{accountId, amount});

        if (!response.isCorrect())
            throw response.getException();
    }

    @Override
    public double getBalance(String accountId) throws InvalidParamException {
        Response response = gernericObjectReference.invokeRemoteMethod("createAccount", new Class[]{String.class}, new Object[]{accountId});

        if (!response.isCorrect())
            throw response.getException();
        else
            return (double) response.getReturnValue();
    }
}
