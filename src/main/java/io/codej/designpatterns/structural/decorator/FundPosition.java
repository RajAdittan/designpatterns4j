package io.codej.designpatterns.structural.decorator;

public class FundPosition extends ProfitLoss {
    private String name;
    private int units;
    private double offer;
    private double last; //this is funds current offer price

    public FundPosition(String name, int units, double offer) {
        this.name = name;
        this.units = units;
        this.offer = offer;
    }

    public String getName() {
        return name;
    }


    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {
        this.offer = offer;
    }

    public void setLast(double last) {
        this.last = last;
    }

    @Override
    public double original() {
        return units*offer;
    }

    @Override
    public double current() {
        return units*last;
    }

    @Override
    public String toString() {
        return "FundPosition{" +
                "name='" + name + '\'' +", " +
                super.toString() +
                '}';
    }
}
