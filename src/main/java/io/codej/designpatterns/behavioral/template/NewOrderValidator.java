package io.codej.designpatterns.behavioral.template;

import java.util.Currency;

public class NewOrderValidator implements TransactionValidator {
    @Override
    public boolean validate(Transaction transaction) {
        System.out.println("validate:");
        NewOrderTrans newOrderTrans = (NewOrderTrans)transaction;
        if(null==newOrderTrans) return false;
        return validateExchange(newOrderTrans.getOrder()) &&
                validateCurrency(newOrderTrans.getOrder());
    }

    private boolean validateExchange(Order order) {
        System.out.println("- validateExchange");
        return null != order && ("nyse" == order.getExchange() || "hkse" == order.getExchange());
    }

    private boolean validateCurrency(Order order) {
        System.out.println("- validateCurrency");
        return null != order && (Currency.getInstance("USD") == order.getCurrency() || Currency.getInstance("HKD") == order.getCurrency());
    }
}
