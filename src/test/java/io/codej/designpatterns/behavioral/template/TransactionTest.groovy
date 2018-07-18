package io.codej.designpatterns.behavioral.template

import java.util.concurrent.ConcurrentHashMap

class TransactionTest extends GroovyTestCase {
    private final NewOrderBuilder builder = new NewOrderBuilder();
    private final NewOrderValidator validator = new NewOrderValidator();
    private final OrderExecutor executor = new OrderExecutor();
    private final ReplaceOrderBuilder rplBuilder = new ReplaceOrderBuilder();
    private final ReplaceOrderValidator rplValidator = new ReplaceOrderValidator();
    /**
     * tests the template method pattern
     * Transaction.transact() is the template method tested as follows
     */
    void testTransact() {

        HashMap<Integer, Order> orders = new ConcurrentHashMap<>();

        NewOrderTrans newOrderTrans = new NewOrderTrans(builder, validator, executor);

        println "new buy 100 HSBC - "
        try {
            newOrderTrans.let("005.HK", 100, 46.78, OrderType.Limit, Side.Buy);
        } finally {
            newOrderTrans.transact();
            orders.put(newOrderTrans.getOrder().getId(), newOrderTrans.getOrder());
        }

        println "new sell 200 IBM - ";
        try {
            newOrderTrans.let("IBM.N", 200, 11.23, OrderType.MarketOnClose, Side.Sell);
        } finally {
            newOrderTrans.transact();
            orders.put(newOrderTrans.getOrder().getId(), newOrderTrans.getOrder());
        }

        ReplaceOrderTrans replaceOrderTrans = new ReplaceOrderTrans(rplBuilder, rplValidator, executor);

        println "rpl 1 120 44.23"
        replaceOrderTrans.setOrder(orders.get(1));

        try {
            replaceOrderTrans.let(44.23, 120);
        } finally {
            replaceOrderTrans.transact();
        }

    }
}
