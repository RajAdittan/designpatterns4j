package io.codej.designpatterns.behavioral.mediator;

import io.codej.designpatterns.behavioral.template.Order;

import java.util.function.Consumer;

public class LogAdapter implements Consumer<Order> {

    @Override
    public void accept(Order order) {
        System.out.println("logger:");
        System.out.println("- " + order);
    }
}

