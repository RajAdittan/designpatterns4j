package io.codej.designpatterns.behavioral.template;

public class ReplaceOrderBuilder implements TransactionBuilder {

    private Order order;

    public ReplaceOrderBuilder(Order order) {
        this.order = order;
    }

    @Override
    public boolean build(Transaction transaction) {
        System.out.println("builder:");
        ReplaceOrderTrans replaceOrderTrans = (ReplaceOrderTrans)transaction;
        System.out.println("- buildSize");
        System.out.println("- buildPrice");
        replaceOrderTrans.set();
        return true;
    }
}
