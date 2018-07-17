package io.codej.designpatterns.behavioral.observer;

public interface Observable {
    void register(Observer observer);
    void unregister(Observer observer);
    void changed();
}
