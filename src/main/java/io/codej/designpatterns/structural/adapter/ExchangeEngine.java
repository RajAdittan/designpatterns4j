package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

public class ExchangeEngine implements ExecutionEngine {
    @Override
    public Result execute(Order order) {
        System.out.println("execution order size " + order.getQuantity() + " [OK]");
        return new Result(true);
    }
}
