package io.codej.designpatterns.structural.bridge;

import java.util.Properties;

public class IntradayContext extends Context {
    private final int start = 12;
    private final int end = 14;

    protected IntradayContext(Properties properties) {
        super(properties);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public void load() {
        getProperties().setProperty("io.context.start", String.format("%d",getStart()));
        getProperties().setProperty("io.context.end", String.format("%d",getEnd()));
        classFactory = new AlgoFactory(getProperties());
        classFactory.resolve();
    }
}
