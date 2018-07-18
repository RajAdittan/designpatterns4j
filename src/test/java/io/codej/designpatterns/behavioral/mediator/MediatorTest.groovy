package io.codej.designpatterns.behavioral.mediator

import io.codej.designpatterns.behavioral.template.Order
import io.codej.designpatterns.creational.prototype.IdGenerator
import io.codej.designpatterns.creational.prototype.OrderIdGenerator

class MediatorTest extends GroovyTestCase {
    private final IdGenerator generator = new OrderIdGenerator();

    void testExecute() {
        OrderProcessor processor = new OrderProcessor();

        LogAdapter adapter = new LogAdapter();
        LogAdapter2 adapter2 = new LogAdapter2();
        ExchangeLink link = new ExchangeLink(processor);

        processor.addOrderConsumer(link);
        processor.addOrderConsumer(adapter);
        processor.addExecutionConsumer(adapter2);

        OrderMangementService oms = new OrderMangementService(processor);
        processor.addExecutionConsumer(oms);

        Order order = createOrder("IBM.N", 100, 23.45f);
        oms.execute(order);
    }

    Order createOrder(String sym, int quantity, double price)
    {
        Order order = new Order(generator.generate());
        order.setSymbol(sym);
        order.setQuantity(quantity);
        order.setPrice(price);
        return order;
    }
}
