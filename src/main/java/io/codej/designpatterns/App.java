package io.codej.designpatterns;

import io.codej.designpatterns.creational.singleton.GlobalRegistry;

/**
 * Hello world!
 *
 */
public class App  {
    private static final GlobalRegistry globalRegistry = GlobalRegistry.instance();

    public static void main( String[] args ) {
        globalRegistry.register(Runnable.class, (Runnable) () -> System.out.println("Hello World"));

        Runnable runnable = globalRegistry.get(Runnable.class);
        runnable.run();
    }
}
