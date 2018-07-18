package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

public interface ExecutionEngine {
    Result execute(Order order);
}
