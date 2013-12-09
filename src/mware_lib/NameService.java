package mware_lib;

import java.io.IOException;

/**
 * Lokal nameservice
 */
public abstract class NameService {
    /**
     * Registers a remote object / service for name
     *
     * @param servant object, processing remote methods
     * @param name    a global unique name of the object / service
     */
    @SuppressWarnings("unused")
    public abstract void rebind(Object servant, String name) throws IOException, ClassNotFoundException, RuntimeException;

    /**
     * Resolves name to a generic object reference
     *
     * @param name a global unique name of the object / service
     * @return a generic object reference
     */
    @SuppressWarnings("unused")
    public abstract Object resolve(String name) throws IOException, ClassNotFoundException;

    /**
     * Close all open connections
     */
    public abstract void shutdown() throws IOException;
}
