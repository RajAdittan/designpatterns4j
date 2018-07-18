package io.codej.designpatterns.behavioral.mediator;

import io.codej.designpatterns.behavioral.template.Order;

public class Execution {
    private int orderId;
    private String symbol;
    private int quantity;
    private double price;

    public Execution(Order order) {
        this.orderId = order.getId();
        this.symbol = order.getSymbol();
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Execution{" +
                "orderId=" + orderId +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
