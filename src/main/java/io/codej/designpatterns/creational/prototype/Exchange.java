package io.codej.designpatterns.creational.prototype;

import java.util.Currency;

public class Exchange {
    private String name;
    private String location;
    private Currency currency;

    public Exchange(String name, String location, Currency currency) {
        this.name = name;
        this.location = location;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
