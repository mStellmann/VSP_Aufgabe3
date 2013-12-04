package bank_access;

import mware_lib.Stub;

/**
 * TODO JavaDoc
 */
public class RemoteAccount extends AccountImplBase {

    private Stub stub;

    public RemoteAccount(Stub stub) {
        this.stub = stub;
    }

    @Override
    public void transfer(double amount) throws OverdraftException {
        // TODO
    }

    @Override
    public double getBalance() {
        return 0;  // TODO
    }
}
