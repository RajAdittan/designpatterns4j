package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

public class ScriptingEngine implements RulesEngine {
    private final NashornEngine javaScriptEngine;
    public ScriptingEngine(NashornEngine javaScriptEngine) {
        this.javaScriptEngine = javaScriptEngine;
    }
    @Override
    public Result execute(Order order) {
        javaScriptEngine.setGlobal("order", order);
        Result result = new Result(false);
        javaScriptEngine.execute(result);
        return result;
    }
}
