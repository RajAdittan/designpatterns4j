package io.codej.designpatterns.structural.adapter;

import io.codej.designpatterns.behavioral.template.Order;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class NashornEngine {
    private final ScriptEngine jsEngine;
    private Invocable invocable;
    private String limitRulesFile;

    public NashornEngine() {
        jsEngine = new ScriptEngineManager().getEngineByName("nashorn");
        setLimitRulesFile("");
    }

    public String getLimitRulesFile() {
        return limitRulesFile;
    }

    public void setLimitRulesFile(String limitRulesFile) {
        this.limitRulesFile = limitRulesFile;
    }

    public void init() {
        if(limitRulesFile=="") {
            System.out.println("limits.js not set");
            return;
        }

        try {
            jsEngine.eval(new FileReader(limitRulesFile));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        invocable = (Invocable) jsEngine;
    }

    public void setGlobal(String entityName, Order entityObject) {
        try {
            invocable.invokeFunction("setGlobal", entityName, entityObject);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void execute(Result result) {
        try {
            invocable.invokeFunction("execute", result);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
