package bank_access;

import mware_lib.GernericObjectReference;
import mware_lib.Response;

/**
 * Stub-Object of the given Interface.
 */
public class ManagerStub extends ManagerImplBase {

    private GernericObjectReference gernericObjectReference;

    public ManagerStub(GernericObjectReference gernericObjectReference) {
        this.gernericObjectReference = gernericObjectReference;
    }

    @Override
    public String createAccount(String owner, String branch) {
        Response response = gernericObjectReference.invokeRemoteMethod("createAccount", new Class[]{String.class, String.class}, new Object[]{owner, branch});

        if (!response.isCorrect())
            throw response.getException();
        else
            return (String) response.getReturnValue();
    }
}
