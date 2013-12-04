package bank_access;

import mware_lib.Stub;

import java.io.Serializable;
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

    public abstract void transfer(double amount) throws OverdraftException;

    public abstract double getBalance();

    public static AccountImplBase narrowCast(Object stub) {
        try {
            if (stub instanceof Stub)
                return new RemoteAccount((Stub) stub);
            else
                throw new RuntimeException("narrowCast of unknown object.");
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - AccountImplBase", cException);
            return null;
        }
    }
}
