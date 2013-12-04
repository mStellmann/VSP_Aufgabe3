package bank_access;

import mware_lib.GernericObjectReference;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO doc
 */
public abstract class AccountImplBase {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(AccountImplBase.class.getName());

    public abstract void transfer(double amount) throws Exception;

    public abstract double getBalance();

    public static AccountImplBase narrowCast(Object gor) {
        try {
            if (gor instanceof GernericObjectReference)
                return new AccountStub((GernericObjectReference) gor);
            else
                throw new RuntimeException("narrowCast of unknown object.");
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - AccountImplBase", cException);
            return null;
        }
    }
}
