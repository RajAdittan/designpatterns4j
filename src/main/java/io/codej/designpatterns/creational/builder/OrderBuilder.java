package io.codej.designpatterns.creational.builder;

import io.codej.designpatterns.behavioral.template.Order;

public class OrderBuilder implements Builder {
    private final Builder instrumentBuilder;
    private final Builder accountBuilder;
    private Builder productBuilder;
    private Builder strategyBuilder;
    private Builder settlementBuilder;

    private Order order;

    public OrderBuilder(Order order) {
        super();
        this.order = order;
        instrumentBuilder = new InstrumentBuilder(this.order);
        accountBuilder = new AccountBuilder(this.order);
        productBuilder = new ProductBuilder(this.order);
        strategyBuilder = new StrategyBuilder(this.order);
    }

    @Override
    public Order build() {
        System.out.println("build:");
        return this
                .buildInstrument()
                .buildAccount()
                .buildProduct()
                .buildStrategy()
                .buildSettlement()
                .order;
    }

    protected OrderBuilder buildInstrument() {
        System.out.println("- build: instrument");
        this.instrumentBuilder.build();
        return this;
    }

    protected OrderBuilder buildAccount() {
        System.out.println("- build: account");
        this.accountBuilder.build();
        return this;
    }

    protected OrderBuilder buildProduct() {
        System.out.println("- build: product");
        this.productBuilder.build();
        return this;
    }

    protected OrderBuilder buildStrategy() {
        System.out.println("- build: strategy");
        this.strategyBuilder.build();
        return this;
    }

    protected OrderBuilder buildSettlement() {
        System.out.println("- build: settlement");
        return this;
    }

}
