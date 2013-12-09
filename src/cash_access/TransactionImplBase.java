package cash_access;

import mware_lib.GernericObjectReference;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class TransactionImplBase {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(TransactionImplBase.class.getName());

    @SuppressWarnings("unused")
    public abstract void deposit(String accountId, double amount)
            throws InvalidParamException;

    @SuppressWarnings("unused")
    public abstract void withdraw(String accountId, double amount)
            throws InvalidParamException, OverdraftException;

    @SuppressWarnings("unused")
    public abstract double getBalance(String accountId)
            throws InvalidParamException;

    /**
     * Casts a TransactionImplBase to a TransactionStub.
     *
     * @param gor GenericObjectReference with the Hostinformation
     * @return Stub-Object of this abstract class
     */
    @SuppressWarnings("unused")
    public static TransactionImplBase narrowCast(Object gor) {
        try {
            if (gor instanceof GernericObjectReference)
                return new TransactionStub((GernericObjectReference) gor);
            else
                throw new RuntimeException("narrowCast of unknown object.");
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - TransactionImplBase", cException);
            return null;
        }
    }
}
