package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

public class OrderExecutor {
    private final RulesEngine rulesEngine;
    private final ExecutionEngine executionEngine;

    public OrderExecutor(ExecutionEngine executionEngine, RulesEngine rulesEngine) {
        this.rulesEngine = rulesEngine;
        this.executionEngine = executionEngine;
    }

    public void execute(Order order) {
        Result result = rulesEngine.execute(order);
        if(result.isSuccess()) {
            System.out.println("check size limit: success");
            result = executionEngine.execute(order);
            if(result.isSuccess()) {
                System.out.println("execution: success");
            } else {
                System.out.println("execution: failed");
                for(Error e: result.getErrors()) {
                    System.out.println(" - " + e.getMessage());
                }
            }
        } else {
            System.out.println("check size limit: failed");
            for(Error e : result.getErrors()) {
                System.out.println(" - " + e.getMessage());
            }
        }
    }
}
