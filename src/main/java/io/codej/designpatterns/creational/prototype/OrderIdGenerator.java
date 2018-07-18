package io.codej.designpatterns.creational.prototype;

public class OrderIdGenerator implements IdGenerator {
    private int id;
    public OrderIdGenerator() {
        id = 0;
    }
    @Override
    public synchronized int generate() {
        return ++id;
    }
}
