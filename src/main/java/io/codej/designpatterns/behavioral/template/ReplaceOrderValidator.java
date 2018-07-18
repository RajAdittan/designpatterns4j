package io.codej.designpatterns.behavioral.template;

public class ReplaceOrderValidator implements TransactionValidator {
    @Override
    public boolean validate(Transaction transaction) {
        System.out.println("validate:");
        ReplaceOrderTrans replaceOrderTrans = (ReplaceOrderTrans)transaction;
        if(replaceOrderTrans!=null) {
            Order order = replaceOrderTrans.getOrder();
            if(order!=null) {
                if(validatePrice(order)) {
                    if(validateQuantity(order)) {
                        if(validateExchange(order)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean validatePrice(Order order) {
        System.out.println("- validatePrice");
        double price = order.getPrice();
        return (price > 0.0f && price < 99.99f) ? true : false;
    }

    private boolean validateQuantity(Order order) {
        System.out.println("- validateQuantity");
        int quantity = order.getQuantity();
        return (quantity > 10 && quantity < 990) ? true : false;
    }

    private boolean validateExchange(Order order) {
        System.out.println("- validateExchange");
        String exch = order.getExchange();
        return (exch == "nyse" || exch == "amex" || exch == "hkse" || exch == "lse" || exch == "tkse") ? true : false;
    }
}
