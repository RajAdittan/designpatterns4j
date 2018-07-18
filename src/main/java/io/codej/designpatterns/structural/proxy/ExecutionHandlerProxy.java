package io.codej.designpatterns.structural.proxy;

public class ExecutionHandlerProxy implements ExecutionHandler {
    private ExecutionHandler [] executionHandlers;
    private int currentHandlerIndex;

    public ExecutionHandlerProxy(int count) {
        this.executionHandlers = new ExecutionHandler[count];
        for(int i=0; i<count; ++i) {
            int execId = i;
            this.executionHandlers[i] = () -> System.out.println("execution: ["+ execId +"] handled");
        }
        this.currentHandlerIndex = 0;
    }

    @Override
    public void execute() {
        if(currentHandlerIndex>=executionHandlers.length)
            currentHandlerIndex = 0;
        this.executionHandlers[currentHandlerIndex++].execute();
    }
}
