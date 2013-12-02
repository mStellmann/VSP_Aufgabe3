package cash_access;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO JavaDoc
 */
public abstract class TransactionImplBase implements Serializable {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(TransactionImplBase.class.getName());

    public abstract void deposit(String accountId, double amount)
            throws InvalidParamException;

    public abstract void withdraw(String accountId, double amount)
            throws InvalidParamException, OverdraftException;

    public abstract double getBalance(String accountId)
            throws InvalidParamException;

    public static TransactionImplBase narrowCast(Object o) {
        try {
            return (TransactionImplBase) o;
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - TransactionImplBase", o);
            return null;
        }
    }
}
