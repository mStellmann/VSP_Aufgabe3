package cash_access;

/**
 * TODO Javadoc
 */
public class RemoteTransaction extends TransactionImplBase {

    public RemoteTransaction(Object obj) {
        // TODO constructor
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
