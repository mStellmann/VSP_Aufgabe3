package bank_access;

@SuppressWarnings("unused")
public class OverdraftException extends Exception {
    public OverdraftException(String msg) {
        super(msg);
    }
}
