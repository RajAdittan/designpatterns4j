package io.codej.designpatterns.structural.decorator

import java.text.DecimalFormat
import java.time.LocalDateTime

class DecoratorTest extends GroovyTestCase {

    class StockPriceWatcher implements Runnable {
        private final Random price = new Random(99);
        private StockPosition stockPosition;

        StockPriceWatcher(StockPosition stockPosition) {
            this.stockPosition = stockPosition
        }

        @Override
        void run() {
            if(0.0==this.stockPosition.current()) {
                this.stockPosition.setLast(this.stockPosition.getPrice());
                return;
            }
            this.stockPosition.setLast(stockPosition.getPrice() * price.nextInt()/50);
        }
    }

    class FundManager implements Runnable {
        private final Random offer = new Random(149);
        private FundPosition fundPosition;

        FundManager(FundPosition fundPosition) {
            this.fundPosition = fundPosition
        }

        @Override
        void run() {
            if(0.0==this.fundPosition.current()) {
                this.fundPosition.setLast(this.fundPosition.getOffer());
                return;
            }
            this.fundPosition.setLast(fundPosition.getOffer()+ fundPosition.getOffer()*offer.nextInt());
        }
    }

    void testDecorator() {

        DecimalFormat formatter = new DecimalFormat(".##");
        StockPosition spos = new StockPosition("IBM.N", 149.24, 100);
        FundPosition fpos = new FundPosition("U.S. Global Jets ETF", 10000, 34.89);

        println "Watch stock price and check your position is profitable or not"
        StockPriceWatcher spWatcher = new StockPriceWatcher(spos);
        LocalDateTime future = LocalDateTime.now().plusSeconds(15);
        while(future >= LocalDateTime.now()) {
            spWatcher.run();
            println spos;
            println("+--");
            if(spos.current() > spos.original()) {
                println "You are making a profit, current profit: " + formatter.format(spos.current() - spos.original());
            } else {
                println "You are yet to make a profit, current loss: " + formatter.format(spos.current() - spos.original());
            }
            println("---")
            Thread.sleep(100*LocalDateTime.now().getSecond());
        }

        println "decorate: Hedege IBM.N with a US fund"
        FundManager fuMan = new FundManager(fpos);
        HedgePosition hpos = new HedgePosition(spos, fpos);
        println "combine the profit+loss of stock+fund and mitigate the risk of both"
        future = LocalDateTime.now().plusSeconds(30);
        while(future >= LocalDateTime.now()) {
            fuMan.run();
            spWatcher.run();
            println hpos;

            println("+--");

            if(hpos.current() > hpos.original()) {
                println "You are making a profit, current profit: " + formatter.format(hpos.current() - hpos.original());
            } else {
                println "You are yet to make a profit, current loss: " + formatter.format(hpos.current() - hpos.original());
            }

            println("---")

            Thread.sleep(100*LocalDateTime.now().getSecond());
        }
    }
}
