package io.codej.designpatterns.structural.proxy

import java.time.LocalDateTime
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

    void testSecureExecute() {
        ExecutionHandler proxy = new SecuredExecutionHandler("rajamohan", "s3cr3tNoIs42");

        IntConsumer consumer = new IntConsumer() {
            @Override
            void accept(int value) {
                proxy.execute();
                if(LocalDateTime.now().getSecond()%2==0) Thread.sleep(5000);
            }
        }

        IntStream.range(1, 10).forEach(consumer);
    }
}
