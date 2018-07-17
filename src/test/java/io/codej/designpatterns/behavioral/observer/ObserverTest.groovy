package io.codej.designpatterns.behavioral.observer

import java.time.LocalDateTime

class ObserverTest extends GroovyTestCase {
    void testUpdate() {
        //create observable
        MarketData marketData = new MarketData("005.HK", 23.45, 22.21);
        //create 2 observers
        PriceWatcher priceWatcher = new PriceWatcher(marketData);
        MarketMaker marketMaker = new MarketMaker(marketData);

        Random random = new Random();
        int counter = 0;

        Runnable stockExchange = new Runnable() {
            @Override
            void run() {//loop: changed() triggers update notification on observers
                if(LocalDateTime.now().getSecond()%2==0) {
                    //ask change triggers MarketMaker
                    marketData
                            .setAsk(random.nextDouble(), random.nextInt())
                            .changed();
                    //last change trigger pricewatcher
                    marketData
                            .setLast(marketData.getAsk(), random.nextInt())
                            .changed();
                    ++counter;
                } else if(LocalDateTime.now().getSecond()%2==1) {
                    //bid change trigger MarketMaker
                    marketData
                            .setBid(random.nextDouble(), random.nextInt())
                            .changed();
                    //last change trigger pricewatcher
                    marketData
                            .setLast(marketData.getBid(), random.nextInt())
                            .changed();
                    ++counter;
                }
            }
        }

        for(int i=360;i>=counter;) {
            stockExchange.run();
            Thread.sleep(random.nextInt(LocalDateTime.now().getMinute()));
        }
    }
}
