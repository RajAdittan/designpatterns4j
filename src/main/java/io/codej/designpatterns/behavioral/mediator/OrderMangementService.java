package io.codej.designpatterns.behavioral.mediator;

import io.codej.designpatterns.behavioral.template.Order;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class OrderMangementService implements Supplier<Order>, Consumer<Execution> {
    private Order currentOrder;
    private OrderProcessor orderProcessor;

    public OrderMangementService(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    public void execute(Order order) {
        currentOrder = order;
        orderProcessor.processOrder(this);
    }

    @Override
    public Order get() {
        return currentOrder;
    }

    @Override
    public void accept(Execution execution) {
        System.out.println("oms execution: ");
        System.out.println("- " + execution);
    }
}
