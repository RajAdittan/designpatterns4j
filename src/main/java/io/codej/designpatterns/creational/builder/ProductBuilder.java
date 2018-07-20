package io.codej.designpatterns.creational.builder;

import io.codej.designpatterns.behavioral.template.Order;

public class ProductBuilder implements Builder {
    private Order order;

    public ProductBuilder(Order order) {
        this.order = order;
    }

    @Override
    public Order build() {
        System.out.println(":productBuilder");
        System.out.println("- build product type");
        System.out.println("- build settlement type");
        return this.order;
    }
}
