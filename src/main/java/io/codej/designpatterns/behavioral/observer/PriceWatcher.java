package io.codej.designpatterns.behavioral.observer;

public class PriceWatcher implements Observer {
    private MarketData marketData;
    private double price;

    public PriceWatcher(MarketData marketData) {
        this.marketData = marketData;
        this.marketData.register(this);
    }

    @Override
    public void update() {
        if(price != marketData.getLast()) {
            System.out.println(marketData);
        }
        price = marketData.getLast();
    }
}
