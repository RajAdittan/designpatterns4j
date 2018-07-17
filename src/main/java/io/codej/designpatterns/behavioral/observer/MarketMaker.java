package io.codej.designpatterns.behavioral.observer;

public class MarketMaker implements Observer {
    private MarketData marketData;
    private double ask;
    private double bid;
    public MarketMaker(MarketData marketData) {
        this.marketData = marketData;
        this.marketData.register(this);
    }

    @Override
    public void update() {
        if(ask!=marketData.getAsk()) {
            ask = marketData.getAsk();
            if(ask+(marketData.getLast()*0.05) >= marketData.getLast()) {
                System.out.println("MarketMaker [" + marketData.getSymbol() + "] suggests to sell");
            }
        }
        if(bid!=marketData.getBid()) {
            bid = marketData.getBid();
            if(bid+(marketData.getLast()*0.05) >= marketData.getLast()) {
                System.out.println("MarketMaker [" + marketData.getSymbol() + "] suggests to buy");
            }
        }
    }
}
