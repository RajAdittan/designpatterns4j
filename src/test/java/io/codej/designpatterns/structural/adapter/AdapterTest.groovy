package io.codej.designpatterns.structural.adapter

import io.codej.designpatterns.behavioral.template.Order
import io.codej.designpatterns.behavioral.template.OrderType
import io.codej.designpatterns.behavioral.template.Side

class AdapterTest extends GroovyTestCase {
    /**
     * adapter pattern : client >> adaptor interface >> adaptor implementation >> adaptee implementation
     */
    void testExecute() {

        //adaptee
        NashornEngine nashornEngine = new NashornEngine();
        nashornEngine.setLimitRulesFile("D:\\usr\\rajamohan\\IdeaProjects\\designpatterns4j\\limits.js");
        nashornEngine.init();

        //the adaptor interface
        RulesEngine rulesEngine = new ScriptingEngine(nashornEngine);
        ExecutionEngine executionEngine = new ExchangeEngine();

        //client code
        OrderExecutor executor = new OrderExecutor(executionEngine, rulesEngine);
        Order order = createTestOrder();
        executor.execute(order);
    }

    private Order createTestOrder() {
        Order order = new Order(1);
        order.setSymbol("IBM.N");
        order.setPrice(11.22);
        order.setQuantity(100);
        order.setSide(Side.Buy);
        order.setType(OrderType.Limit);
        return order;
    }
}
