package io.codej.designpatterns.creational.singleton;

import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Singleton class
 */
public class GlobalRegistry {

    // singleton
    static class InternalRegistry { //Singleton Step 2: define inner class to hold instance of GlobalRegistry
        private InternalRegistry() {} //Note: do not allow users to create instance of internal registery
        static GlobalRegistry INSTANCE = new GlobalRegistry(); // instance is created only once
    } // the class loader is always sequential

    private GlobalRegistry() {} //Singleton Step 1: Make constructor private

    public static GlobalRegistry instance() { //Singleton Step 3: create a static method to return singleton instance
        return InternalRegistry.INSTANCE;
    }

    // registry functionality
    private final ConcurrentHashMap<Type, Object> registry = new ConcurrentHashMap<>();

    /**
     * registers an object with the specified type
     * @param intrface interface type
     * @param implInst implementation instance as Object
     */
    public void register(Type intrface, Object implInst)  {
        registry.put(intrface, implInst);
    }

    /**
     * checks if the specified interface type is registered in this repository
     * @param intrface interface type
     * @return true if the interface type is registered; false otherwise
     */
    public boolean isRegistered(final Type intrface) {
        return registry.containsKey(intrface);
    }

    /**
     * Generic method to get the registered instance
     * @param intrface interface type
     * @param <E> implementation class
     * @return registered instance of implementation class
     */
    public <E> E get(Type intrface) {
        if(registry.containsKey(intrface)) {
            Object value = registry.get(intrface);
            return (E) value;
        }
        return null;
    }

}
