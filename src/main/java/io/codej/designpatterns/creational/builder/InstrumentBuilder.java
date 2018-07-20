package io.codej.designpatterns.creational.builder;

import io.codej.designpatterns.behavioral.template.Order;

import java.util.Currency;

public class InstrumentBuilder implements Builder {
    private Order order;

    public InstrumentBuilder(Order order) {
        this.order = order;
    }

    @Override
    public Order build() {
        System.out.println("- instrumentbuilder");
        String sym = order.getSymbol().toUpperCase();
        try {
            if (sym.endsWith(".N")) {
                order.setExchange("NYSE");
                order.setCurrency(Currency.getInstance("USD"));
            } else if(sym.endsWith(".HK")) {
                order.setExchange("HKSE");
                order.setCurrency(Currency.getInstance("HKD"));
            } else if(sym.endsWith(".JP")) {
                order.setExchange("JPSE");
                order.setCurrency(Currency.getInstance("JPY"));
            } else if(sym.endsWith(".L")) {
                order.setExchange("LSE");
                order.setCurrency(Currency.getInstance("GBP"));
            }
        } finally {
            System.out.println("symbol:" + sym + " {exchange:" + order.getExchange() + ", currency:" + order.getCurrency() + "}");
        }
        return this.order;
    }
}


