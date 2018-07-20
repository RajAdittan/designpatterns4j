package io.codej.designpatterns.structural.decorator;

/**
 * This is a decorator of stock + fund positions
 */
public class HedgePosition extends ProfitLoss {
    private StockPosition stockPosition;
    private FundPosition fundPosition;

    public HedgePosition(StockPosition stockPosition, FundPosition fundPosition) {
        this.stockPosition = stockPosition;
        this.fundPosition = fundPosition;
    }

    @Override
    public double original() {
        return stockPosition.original() + fundPosition.original();
    }

    @Override
    public double current() {
        return stockPosition.current() + fundPosition.current();
    }

    @Override
    public String toString() {

        return "HedgePosition{" +
                "stockPosition=" + stockPosition + '\n' +
                ", fundPosition=" + fundPosition + '\n' +
                ", hedgeOriginal=" + original() +
                ", hedgeCurrent=" + current() + '\n' +
                '}';
    }
}
