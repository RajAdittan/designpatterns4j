package io.codej.designpatterns.behavioral.template;

import java.time.LocalDateTime;
import java.util.Currency;

public class Order {
    private int id;
    private String symbol;
    private String exchange;
    private Currency currency;
    private int quantity;
    private double price;
    private Side side;
    private OrderType type;
    private LocalDateTime creationStamp;
    private LocalDateTime changeStamp;

    public Order(int id) {
        this.id = id;
        this.creationStamp = LocalDateTime.now();
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

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public LocalDateTime getCreationStamp() {
        return creationStamp;
    }

    public LocalDateTime getChangeStamp() {
        return changeStamp;
    }

    public void setChangeStamp(LocalDateTime changeStamp) {
        this.changeStamp = changeStamp;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Side getSide() {
        return side;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", currency=" + currency +
                ", quantity=" + quantity +
                ", price=" + price +
                ", side=" + side +
                ", type=" + type +
                ", creationStamp=" + creationStamp +
                ", changeStamp=" + changeStamp +
                '}';
    }
}

