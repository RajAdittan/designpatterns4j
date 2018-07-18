package io.codej.designpatterns.behavioral.template;

public class NewOrderTrans extends Transaction {

    private Order order;
    private String symbol;
    private int quantity;
    private double price;
    private OrderType type;
    private Side side;

    protected NewOrderTrans(TransactionBuilder builder, TransactionValidator validator, TransactionExecutor executor) {
        super(builder, validator, executor);
    }

    public void let(String symbol, int quantity, double price, OrderType type, Side side) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.side = side;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        set();
    }

    private void set() {
        this.order.setSymbol(this.symbol);
        this.order.setQuantity(this.quantity);
        this.order.setPrice(this.price);
        this.order.setType(this.type);
        this.order.setSide(this.side);
    }

    @Override
    public String toString() {
        return "NewOrderTrans{" +
                "order=" + order +
                '}';
    }
}
