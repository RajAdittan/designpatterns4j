package io.codej.designpatterns.creational.prototype

class PrototypeTest extends GroovyTestCase {

    void testCreate() {

        Exchange exch = new Exchange("hkse", "Hong kong", Currency.getInstance("HKD"));

        Entity entity = new Entity(exch);

        // following order objects uses same exch reference
        Order hkseOrder1 = entity.create("005.HK", 100, 12.23);
        Order hkseOrder2 = entity.create("010.HK", 50, 24.73);
        Order hkseOrder3 = entity.create("015.HK", 10, 72.12);
        Order hkseOrder4 = entity.create("020.HK", 30, 36.56);

        println hkseOrder1;
        println hkseOrder2;
        println hkseOrder3;
        println hkseOrder4;
        println hkseOrder5;

    }

    void testPrototype() {
        Exchange exch = new Exchange("hkse", "Hong kong", Currency.getInstance("HKD"));
        IdGenerator gen = new OrderIdGenerator();
        //create a prototype with necessary building blocks
        Order prototype = new Order(exch, gen);
        //use clone to avoid recreation of necessary building blocks, rather use it from the prototype
        Order order1 = prototype.clone().update("001.HK", 20, 12.11);
        println order1;
        order1 = null;
        order1 = prototype.clone().update("005.HK", 10, 24.11);
        println order1;
    }
}
