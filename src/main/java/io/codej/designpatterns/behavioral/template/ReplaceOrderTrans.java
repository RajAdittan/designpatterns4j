package io.codej.designpatterns.behavioral.template;

public class ReplaceOrderTrans extends Transaction {

    private double price;
    private int quantity;

    private Order order;

    protected ReplaceOrderTrans(TransactionBuilder builder, TransactionValidator validator, TransactionExecutor executor) {
        super(builder, validator, executor);
    }

    public void let(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public void set() {
        this.order.setPrice(this.price);
        this.order.setQuantity(this.quantity);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ReplaceOrderTrans{" +
                "order=" + order +
                '}';
    }
}
