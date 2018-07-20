package io.codej.designpatterns.structural.decorator;

public class StockPosition extends ProfitLoss {
    private String symbol;
    private double price;
    private int quantity;
    private double last; // this is current market price

    public StockPosition(String symbol, double price, int quantity) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double original() {
        return quantity * price;
    }

    @Override
    public double current() {
        return quantity * last;
    }

    @Override
    public String toString() {
        return "StockPosition{" +
                "symbol='" + symbol + '\'' + ", " +
                super.toString() +
                '}';
    }
}

