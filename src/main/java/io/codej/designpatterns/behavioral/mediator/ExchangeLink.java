package io.codej.designpatterns.behavioral.mediator;

import io.codej.designpatterns.behavioral.template.Order;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExchangeLink implements Consumer<Order>, Supplier<Execution> {
    private final OrderProcessor processor;
    private Execution execution;
    private ExchangeLink(OrderProcessor processor) {
        this.processor = processor;
    }
    @Override
    public void accept(Order order) {
        System.out.println("exchange link:");
        System.out.println("- " + order);
        execution = new Execution(order);
        execution.setPrice(order.getPrice() * 1.1);
        execution.setQuantity(order.getQuantity());
        processor.processExecution(this);
    }

    @Override
    public Execution get() {
        return execution;
    }
}

