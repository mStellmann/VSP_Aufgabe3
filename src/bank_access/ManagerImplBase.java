package bank_access;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO doc
 */
public abstract class ManagerImplBase implements Serializable {
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(ManagerImplBase.class.getName());
    private static final long serialVersionUID = 164997905243190494L;


    public abstract String createAccount(String owner, String branch);

    public static ManagerImplBase narrowCast(Object o) {
        try {
            return new RemoteManager(o);
        } catch (ClassCastException cException) {
            log.log(Level.SEVERE, "ClassCastException - ManagerImplBase", cException);
            return null;
        }
    }
}
