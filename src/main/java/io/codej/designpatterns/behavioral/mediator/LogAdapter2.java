package io.codej.designpatterns.behavioral.mediator;

import java.util.function.Consumer;

public class LogAdapter2 implements Consumer<Execution> {
    @Override
    public void accept(Execution execution) {
        System.out.println("logger:");
        System.out.println("- " + execution);
    }
}
