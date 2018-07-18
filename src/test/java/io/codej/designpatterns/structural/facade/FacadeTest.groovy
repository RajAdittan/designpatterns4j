package io.codej.designpatterns.structural.facade

import io.codej.designpatterns.behavioral.template.Order
import io.codej.designpatterns.behavioral.template.OrderType
import io.codej.designpatterns.behavioral.template.Side

class FacadeTest extends GroovyTestCase {
    private Oms oms;
    private int id = -1;

    @Override
    void setUp() {
        super.setUp()
        oms = new OmsImpl()
        Order order = oms.create();
        order.setType(OrderType.Limit);
        order.setPrice(11.22);
        order.setSide(Side.Sell);
        order.setQuantity(99);
        order.setSymbol("IBM.N");
        println "create:" + order;
        id = order.getId();
    }

    void testCreate() {
        Order order = oms.create();
        order.setType(OrderType.Limit);
        order.setPrice(11.22);
        order.setSide(Side.Sell);
        order.setQuantity(99);
        order.setSymbol("IBM.N");
        println "create:" + order;
        id = order.getId();
    }

    void testReplace() {
        Order order = oms.query(id);
        order.setPrice(22.33);
        order.setQuantity(200);
        oms.replace(order);
    }

    void testCancel() {
        Order order = oms.query(id);
        oms.cancel(order);
        testCreate();
    }

    void testClose() {
        oms.close(id);
    }

    void testQuery() {
        testCreate();
        Order order = oms.query(id);
        println order;
    }

    void testQueryClosed() {

    }

    void testExecute() {
        oms.execute(id);
    }
}
