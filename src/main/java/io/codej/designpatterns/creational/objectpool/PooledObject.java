package io.codej.designpatterns.creational.objectpool;

public abstract class PooledObject implements Poolable, Controlable {
    protected boolean inUse;

    @Override
    public synchronized void activate() {
        inUse = true;
    }

    @Override
    public synchronized void deactivate() {
        inUse = false;
    }

    @Override
    public abstract void reset();
}
