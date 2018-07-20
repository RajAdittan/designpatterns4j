package io.codej.designpatterns.creational.builder

import io.codej.designpatterns.behavioral.template.Order
import io.codej.designpatterns.behavioral.template.OrderType
import io.codej.designpatterns.behavioral.template.Side
import io.codej.designpatterns.creational.prototype.OrderIdGenerator

class BuilderTest extends GroovyTestCase {
    private final OrderIdGenerator generator = new OrderIdGenerator();

    void testBuilder() {
        Order order = new Order(generator.generate());
        Builder builder = new OrderBuilder(order);
        order.setSymbol("IBM.N");
        order.setQuantity(100);
        order.setPrice(149.941);
        order.setSide(Side.Buy);
        order.setType(OrderType.Limit);
        String user = System.getProperty("user.name");
        order.setUser(user);
        order.setDesk("cash");
        println "values set by user:" + order;
        builder.build();
        println "values after build:" + order;
    }
}
