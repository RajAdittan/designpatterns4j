package io.codej.designpatterns.behavioral.template;

public class OrderExecutor implements TransactionExecutor {
    @Override
    public void execute(Transaction transaction) {
        System.out.println("execute:");
        System.out.println("- " + transaction);
    }

    public void execute(Order order) {
        System.out.println("execute:");
        System.out.println("- " + order);
    }
}
