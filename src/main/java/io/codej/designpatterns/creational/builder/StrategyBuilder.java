package io.codej.designpatterns.creational.builder;

import io.codej.designpatterns.behavioral.template.Order;

public class StrategyBuilder implements Builder {
    private Order order;

    public StrategyBuilder(Order order) {
        this.order = order;
    }

    @Override
    public Order build() {
        System.out.println(":strategyBuilder");
        System.out.println("- execution strategy set");
        return this.order;
    }
}
