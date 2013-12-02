package bank_access;

/**
 * TODO doc
 */
public abstract class ManagerImplBase {
    public abstract String createAccount(String owner, String branch);

    public static ManagerImplBase narrowCast(Object gor) {
        return null; // TODO narrowCast()
    }
}
