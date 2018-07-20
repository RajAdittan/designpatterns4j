package io.codej.designpatterns.structural.bridge;

import java.util.Properties;


abstract class Algorithm {

}

public class AlgoFactory implements ClassFactory {
    private final Properties properties;
    private Algorithm algorithm;

    public AlgoFactory(Properties properties) {
        this.properties = properties;
    }

    public Algorithm get() {
        return algorithm;
    }

    @Override
    public void resolve() {
        int start = Integer.parseInt((String) properties.get("io.context.start"));
        int end = Integer.parseInt((String) properties.get("io.context.end"));
        if(start >= 6 && end < 10) {
            algorithm = new StartOfDayAlgo();
        } else if(start >= 12 && end < 15) {
            algorithm = new IntraDayAlgo();
        } else if(start >= 16 && end < 19) {
            algorithm = new EndOfDayAlgo();
        }
    }
}


