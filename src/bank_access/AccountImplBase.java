package bank_access;

/**
 * TODO doc
 */
public abstract class AccountImplBase {
    public abstract void transfer(double amount) throws OverdraftException;

    public abstract double getBalance();

    public static AccountImplBase narrowCast(Object o) {
        return null; // TODO narrowCast()
    }
}
