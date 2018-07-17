package io.codej.designpatterns.creational.prototype;

public class Entity {

    private final Exchange exchange;
    private final Order prototype;
    private final IdGenerator generator;

    public Entity(Exchange exchange) {
        this.exchange = exchange;
        generator = new OrderIdGenerator();
        //create prototype object to clone and create new order instances
        prototype = new Order(exchange, generator);
    }

    public Order create(String symbol, int quantity, double price) {
        // exchange reference is copied internally, generates order id from prototype
        return prototype
                .clone()
                .update(symbol, quantity, price);
    }

}
