package bank_access;

import mware_lib.Stub;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO doc
 */
public abstract class ManagerImplBase {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(ManagerImplBase.class.getName());

    public abstract String createAccount(String owner, String branch);

    public static ManagerImplBase narrowCast(Object stub) {
        try {
            if (stub instanceof Stub)
                return new RemoteManager((Stub) stub);
            else
                throw new RuntimeException("narrowCast of unknown object.");
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - ManagerImplBase", cException);
            return null;
        }
    }
}
