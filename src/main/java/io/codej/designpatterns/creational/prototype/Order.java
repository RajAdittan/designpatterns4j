package io.codej.designpatterns.creational.prototype;

import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class Order implements Cloneable {

    private Exchange executionVenue;
    private IdGenerator generator;

    private int id;
    private String symbol;
    private int quantity;
    private double price;
    private Date creationStamp;
    private Date changeStamp;

    private Order(Exchange executionVenue, int id) {
        this.id = id;
        this.executionVenue = executionVenue;
        this.creationStamp = Date.from(Calendar.getInstance().toInstant());
        this.changeStamp = this.creationStamp;
    }

    protected Order(Exchange executionVenue, IdGenerator generator) {
        this.generator = generator;
        this.executionVenue = executionVenue;
    }

    public Order(int id, String symbol, int quantity, double price) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.creationStamp = Date.from(Calendar.getInstance().toInstant());
        this.changeStamp = this.creationStamp;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public Date getCreationStamp() {
        return creationStamp;
    }

    public void setCreationStamp(Date creationStamp) {
        this.creationStamp = creationStamp;
    }

    public Date getChangeStamp() {
        return changeStamp;
    }

    public void setChangeStamp(Date changeStamp) {
        this.changeStamp = changeStamp;
    }

    public String getExchange() {
        return executionVenue.getName();
    }

    public String getLocation() {
        return executionVenue.getLocation();
    }

    public Currency getCurrency() {
        return executionVenue.getCurrency();
    }

    public Order update(String symbol, int quantity, double price) {
        setSymbol(symbol);
        setQuantity(quantity);
        setPrice(price);
        return this;
    }

    @Override
    public Order clone() {
        return new Order(this.executionVenue, generator.generate());
    }

    @Override
    public String toString() {
        return "Order{" +
                "executionVenue=" + executionVenue +
                ", id=" + id +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", creationStamp=" + creationStamp +
                ", changeStamp=" + changeStamp +
                '}';
    }
}
