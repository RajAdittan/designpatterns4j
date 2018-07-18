package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

public interface RulesEngine {
   Result execute(Order order);
}


