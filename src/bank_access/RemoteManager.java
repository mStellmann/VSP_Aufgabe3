package bank_access;

import mware_lib.Stub;

/**
 * TODO JavaDoc
 */
public class RemoteManager extends ManagerImplBase {

    private Stub stub;

    public RemoteManager(Stub stub) {
        this.stub = stub;
    }

    @Override
    public String createAccount(String owner, String branch) {
        return null;  // TODO
    }
}
