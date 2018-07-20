package io.codej.designpatterns.structural.bridge;

public interface ClassFactory {
    Algorithm get();
    void resolve();
}
