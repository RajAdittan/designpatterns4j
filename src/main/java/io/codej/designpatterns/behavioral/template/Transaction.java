package io.codej.designpatterns.behavioral.template;

public class Transaction {

    private TransactionBuilder builder;
    private TransactionValidator validator;
    private TransactionExecutor executor;

    protected Transaction(TransactionBuilder builder, TransactionValidator validator, TransactionExecutor executor) {
        this.builder = builder;
        this.validator = validator;
        this.executor = executor;
    }

    /**
     * template method
     */
    public void transact() {
        System.out.println("transaction:");
        if(builder.build(this)) {
            if(validator.validate(this)) {
                executor.execute(this);
            }
        }
    }
}
