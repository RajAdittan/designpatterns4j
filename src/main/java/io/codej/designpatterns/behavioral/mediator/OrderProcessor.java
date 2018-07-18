package io.codej.designpatterns.behavioral.mediator;

import io.codej.designpatterns.behavioral.template.Order;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * this class is the mediator between supplier and consumers
 */
public class OrderProcessor {
    private List<Consumer<Order>> orderConsumers = new CopyOnWriteArrayList<>();
    private List<Consumer<Execution>> execConsumers = new CopyOnWriteArrayList<>();

    public void addOrderConsumer(Consumer<Order> consumer) {
        orderConsumers.add(consumer);
    }
    public void addExecutionConsumer(Consumer<Execution> consumer) {execConsumers.add(consumer); }

    /**
     * mediates call to register consumers
     * @param supplier Order input provider
     * @implNote current impl is sequential processing. change stream() to parallelStream() to make it parallel
     * e.g. consumers.parallelStream().forEach(consumer -> consumer.accept(supplier.get()));
     */
    public void processOrder(Supplier<Order> supplier) {
        orderConsumers.stream().forEach(consumer -> consumer.accept(supplier.get()));
    }

    public void processExecution(Supplier<Execution> supplier) {
        execConsumers.stream().forEach(consumer -> consumer.accept(supplier.get()));
    }
}
