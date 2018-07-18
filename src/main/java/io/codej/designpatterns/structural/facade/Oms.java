package io.codej.designpatterns.structural.facade;

import io.codej.designpatterns.behavioral.template.Order;

/**
 * Order management service interface
 */
public interface Oms {
    Order create();
    void replace(Order order);
    void cancel(Order order);
    void close(int id);

    Order query(int id);
    Order queryClosed(int id);

    void execute(int id);
}
