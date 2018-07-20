package io.codej.designpatterns.structural.decorator;

import java.text.DecimalFormat;

public abstract class ProfitLoss {

    private static DecimalFormat PriceFormatter = new DecimalFormat(".##");

    public abstract double original();
    public abstract double current();
    public double value() {
        return current() - original();
    }

    @Override
    public String toString() {
        return "ProfitLoss {" +
                "original:" + PriceFormatter.format(original()) + ", " +
                "current:" + PriceFormatter.format(current()) + ", " +
                "value:" + PriceFormatter.format(value()) +
                "}";
    }
}
