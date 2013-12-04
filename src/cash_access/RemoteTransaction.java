package cash_access;

import mware_lib.Stub;

/**
 * TODO Javadoc
 */
public class RemoteTransaction extends TransactionImplBase {

    private Stub stub;

    public RemoteTransaction(Stub stub) {
        this.stub = stub;
    }

    @Override
    public void deposit(String accountId, double amount) throws InvalidParamException {
        // TODO
    }

    @Override
    public void withdraw(String accountId, double amount) throws InvalidParamException, OverdraftException {
        // TODO
    }

    @Override
    public double getBalance(String accountId) throws InvalidParamException {
        return 0;  // TODO
    }
}
