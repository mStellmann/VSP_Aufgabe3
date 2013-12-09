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
        System.out.println("--- invoke on client ---");
        Response response = gernericObjectReference.invokeRemoteMethod("createAccount", new Class[]{String.class, String.class}, new Object[]{owner, branch});
        System.out.println("--- response on client ---");
        if (!response.isCorrect())
            throw response.getException();
        else
            return (String) response.getReturnValue();
    }
}
