package io.codej.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<Error> errors = new ArrayList<>();
    private boolean success;

    public Result(boolean success) {
        this.success = success;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
