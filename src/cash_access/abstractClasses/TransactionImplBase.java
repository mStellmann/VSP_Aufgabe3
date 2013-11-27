package cash_access.abstractClasses;

import cash_access.exceptions.InvalidParamException;
import cash_access.exceptions.OverdraftException;

/**
 * TODO JavaDoc
 */
public abstract class TransactionImplBase {
    public abstract void deposit(String accountId, double amount)
            throws InvalidParamException;

    public abstract void withdraw(String accountId, double amount)
            throws InvalidParamException, OverdraftException;

    public abstract double getBalance(String accountId)
            throws InvalidParamException;

    public static TransactionImplBase narrowCast(Object o) {
        return null; // TODO narrowCast()
    }
}
