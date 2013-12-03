package bank_access;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO doc
 */
public abstract class AccountImplBase implements Serializable {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(AccountImplBase.class.getName());
    private static final long serialVersionUID = 5898718024226037921L;


    public abstract void transfer(double amount) throws OverdraftException;

    public abstract double getBalance();

    public static AccountImplBase narrowCast(Object o) {
        try {
            return (AccountImplBase) o;
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - AccountImplBase", cException);
            return null;
        }
    }
}
