package io.codej.designpatterns.behavioral.template;

import io.codej.designpatterns.creational.prototype.IdGenerator;
import io.codej.designpatterns.creational.prototype.OrderIdGenerator;

import java.util.Currency;

public class NewOrderBuilder implements TransactionBuilder {
    private final IdGenerator generator = new OrderIdGenerator();
    @Override
    public boolean build(Transaction transaction) {
        NewOrderTrans newOrderTrans = (NewOrderTrans)transaction;
        if(null==newOrderTrans) return false;
        Order order = new Order(generator.generate());
        newOrderTrans.setOrder(order);
        return buildExchange(order);
    }

    protected boolean buildExchange(Order order) {
        System.out.println("builder:");
        try {
            if (order.getSymbol().endsWith("N")) {
                order.setExchange("nyse");
                order.setCurrency(Currency.getInstance("USD"));
                return true;
            } else if (order.getSymbol().endsWith("TK")) {
                order.setExchange("tkse");
                order.setCurrency(Currency.getInstance("JPY"));
                return true;
            } else if (order.getSymbol().endsWith("L")) {
                order.setExchange("lse");
                order.setCurrency(Currency.getInstance("GBP"));
                return true;
            } else if (order.getSymbol().endsWith("HK")) {
                order.setExchange("hkse");
                order.setCurrency(Currency.getInstance("HKD"));
                return true;
            }
            return false;
        } finally {
            System.out.println("- buildExchange{ exch:" + order.getExchange() + ", curr: " + order.getCurrency() +"}");
        }
    }
}


