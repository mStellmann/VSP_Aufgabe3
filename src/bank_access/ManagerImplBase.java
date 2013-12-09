package bank_access;

import mware_lib.GernericObjectReference;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ManagerImplBase {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(ManagerImplBase.class.getName());

    @SuppressWarnings("unused")
    public abstract String createAccount(String owner, String branch);

    /**
     * Casts a ManagerImplBase to a ManagerStub.
     *
     * @param gor GenericObjectReference with the Hostinformation
     * @return Stub-Object of this abstract class
     */
    @SuppressWarnings("unused")
    public static ManagerImplBase narrowCast(Object gor) {
        try {
            if (gor instanceof GernericObjectReference)
                return new ManagerStub((GernericObjectReference) gor);
            else
                throw new RuntimeException("narrowCast of unknown object.");
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - ManagerImplBase", cException);
            return null;
        }
    }
}
