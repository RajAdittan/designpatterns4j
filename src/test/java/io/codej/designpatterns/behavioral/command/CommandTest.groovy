package io.codej.designpatterns.behavioral.command

import io.codej.designpatterns.behavioral.template.Order

class CommandTest extends GroovyTestCase {
    void testExecute() {
        Order o = new Order(1);
        o.setQuantity(100);
        o.setPrice(12.23);
        o.setSymbol("005.HK");
        o.setExchange("hkse")

        ExecuteCommand command = new ExecuteOrder(o);
        command.execute();
    }

    void testBatchCommand() {
        Order o = new Order(1);
        o.setQuantity(100);
        o.setPrice(12.23);
        o.setSymbol("005.HK");
        o.setExchange("hkse")

        BatchExecute batch = new BatchExecute();
        batch.add(new ExecuteOrder(o));
        batch.add(new ExecuteFill("005.HK", 12.10, 20));
        batch.add(new ExecuteFill("005.HK", 12.40, 20));
        batch.add(new ExecuteFill("005.HK", 12.20, 20));
        batch.add(new ExecuteFill("005.HK", 12.30, 20));
        batch.add(new ExecuteFill("005.HK", 12.23, 20));

        batch.execute();
    }
}
