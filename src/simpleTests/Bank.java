package simpleTests;

import mware_lib.NameService;
import mware_lib.ObjectBroker;

/**
 * TODO JavaDoc
 */
public class Bank {
    ObjectBroker ob = ObjectBroker.init("localhost", 12345);
    NameService ns = ob.getNameService();



    ns.rebind((Object) konto, kontoID);
    //...
    ob.shutdown();

}
