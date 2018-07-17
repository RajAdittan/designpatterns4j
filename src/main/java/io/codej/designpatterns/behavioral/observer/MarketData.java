package io.codej.designpatterns.behavioral.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MarketData implements Observable {
    private List<Observer> observers = new CopyOnWriteArrayList<>();

    private String symbol;
    private double ask;
    private int askSize;
    private double bid;
    private int bidSize;
    private double last;
    private int lastSize;
    private double open;
    private double close;
    private double high;
    private double low;
    private long vol;

    public MarketData(String symbol, double open, double close) {
        this.symbol = symbol;
        this.open = open;
        this.close = close;
    }

    public MarketData startOfDay(double open) {
        setOpen(open);
        return this;
    }

    public MarketData endOfDay(double close) {
        setClose(close);
        return this;
    }

    public MarketData setAsk(double ask, int askSize) {
        setAsk(ask);
        setAskSize(askSize);
        return this;
    }

    public MarketData setBid(double bid, int bidSize) {
        setBid(bid);
        setAskSize(bidSize);
        return this;
    }

    public MarketData setLast(double last, int lastSize) {
        setLast(last);
        setLastSize(lastSize);
        setVol(getVol()+getLastSize());
        return this;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void changed() {
        observers
                .stream()
                .forEach(o -> o.update());
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public double getBid() {
        return bid;
    }

    protected void setBid(double bid) {
        this.bid = bid;
    }

    public int getBidSize() {
        return bidSize;
    }

    protected void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public double getLast() {
        return last;
    }

    protected void setLast(double last) {
        this.last = last;
        if(last > high) {
            setHigh(last);
        } else if(last < low) {
            setLow(low);
        }
    }

    public int getLastSize() {
        return lastSize;
    }

    protected void setLastSize(int lastSize) {
        this.lastSize = lastSize;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    protected void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    protected void setLow(double low) {
        this.low = low;
    }

    public long getVol() {
        return vol;
    }

    protected void setVol(long vol) {
        this.vol = vol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "symbol='" + symbol + '\'' +
                ", ask=" + ask +
                ", askSize=" + askSize +
                ", bid=" + bid +
                ", bidSize=" + bidSize +
                ", last=" + last +
                ", lastSize=" + lastSize +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", vol=" + vol +
                '}';
    }
}
