package io.codej.designpatterns.behavioral.command;

public class ExecuteFill implements ExecuteCommand  {
    private String symbol;
    private double price;
    private int quantity;

    public ExecuteFill(String symbol, double price, int quantity) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        System.out.println("execute:");
        System.out.println(String.format("- fill{ symbol:%s, quantity:%d, price:%f}", symbol, quantity, price));
    }
}
