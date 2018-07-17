package io.codej.designpatterns.creational.singleton;

import groovy.util.GroovyTestCase;

import java.io.Closeable;
import java.io.IOException;

public class GlobalRegistryTest extends GroovyTestCase {

    private static String MSG_CLOSE = "closeable.close(): [info] {some message to print at close}";

    public GlobalRegistryTest() {
        super();
    }

    /**
     * tests singleton instance
     */
    public void testInstance() {
        //access singleton instance
        GlobalRegistry registry1 = GlobalRegistry.instance();
        assert (null != registry1);

        //get a new reference
        GlobalRegistry registry2 = GlobalRegistry.instance();
        assert (null != registry2);

        // assert reference equals
        assert (registry2 == registry1);
    }

    /**
     * test register method
     */
    public void testRegister() {
        Closeable closeable = () -> System.out.println(MSG_CLOSE);
        GlobalRegistry.instance().register(Closeable.class, closeable);
    }

    public void testRegistered() {
        Closeable closeable = () -> System.out.println(MSG_CLOSE);
        GlobalRegistry.instance().register(Closeable.class, closeable);
        assert(true==GlobalRegistry.instance().isRegistered(Closeable.class));
    }

    public void testGet() {
        Closeable closeable = () -> {System.out.println(MSG_CLOSE); throw new IOException("execption thrown from close");};
        GlobalRegistry.instance().register(Closeable.class, closeable);
        Closeable closeable1 = GlobalRegistry.instance().get(Closeable.class);
        try {
            closeable1.close();
        } catch (IOException e) {
        }
    }
}