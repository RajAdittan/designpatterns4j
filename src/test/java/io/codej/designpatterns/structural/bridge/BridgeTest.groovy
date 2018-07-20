package io.codej.designpatterns.structural.bridge

class BridgeTest extends GroovyTestCase {
    private final Properties properties = new Properties();

    void testBridge() {

        println "bridge: context is set to start-of-day"
        Context ctx = new InitialContext(properties);
        ctx.load();
        ClassFactory classFactory = ctx.getClassFactory();
        Algorithm algorithm = classFactory.get();
        println algorithm;

        println "bridge: context is set to intra-day"
        ctx = new IntradayContext(properties);
        ctx.load();
        classFactory = ctx.getClassFactory();
        algorithm = classFactory.get();
        println algorithm;

        println "bridge: context is set to end-of-day"
        ctx = new EndOfDayContext(properties);
        ctx.load();
        classFactory = ctx.getClassFactory();
        algorithm = classFactory.get();
        println algorithm;
    }
}
