package io.codej.designpatterns.structural.proxy

import java.util.function.IntConsumer
import java.util.stream.IntStream

class ProxyTest extends GroovyTestCase {
    void testExecute() {

        ExecutionHandler proxy = new ExecutionHandlerProxy(2);

        IntConsumer consumer = new IntConsumer() {
            @Override
            void accept(int value) {
                proxy.execute();
            }
        }

        IntStream.range(1, 10).parallel().forEach(consumer);

    }
}
