package io.codej.designpatterns.structural.bridge;

import java.util.Properties;

public abstract class Context {
    private Properties properties;
    protected ClassFactory classFactory;

    protected Context(Properties properties) {
        this.properties = properties;
    }


    public ClassFactory getClassFactory() { return classFactory; }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public abstract void load();
}


