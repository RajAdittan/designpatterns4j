package io.codej.designpatterns.behavioral.command;

import io.codej.designpatterns.behavioral.template.Order;

public class ExecuteOrder implements ExecuteCommand {

    private Order order;

    public ExecuteOrder(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println("execute:");
        System.out.println("- " + order);
    }
}
