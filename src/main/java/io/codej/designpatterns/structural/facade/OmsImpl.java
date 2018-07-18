package io.codej.designpatterns.structural.facade;

import io.codej.designpatterns.behavioral.template.Order;
import io.codej.designpatterns.behavioral.template.OrderExecutor;
import io.codej.designpatterns.creational.prototype.IdGenerator;
import io.codej.designpatterns.creational.prototype.OrderIdGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class OmsImpl implements Oms {
    private final IdGenerator generator = new OrderIdGenerator();
    private final OrderExecutor executor = new OrderExecutor();
    private final Map<Integer, Order> store = new ConcurrentHashMap<>();
    private final List<Order> closedOrders = new CopyOnWriteArrayList<>();

    @Override
    public Order create() {
        int id = generator.generate();
        Order order = new Order(id);
        store.put(id, order);
        return order;
    }

    @Override
    public void replace(Order order) {
        System.out.println("replace:");
        Order o = store.get(order.getId());
        if(o==null) return;
        o.setQuantity(order.getQuantity());
        o.setPrice(order.getPrice());
        o.setExchange(order.getExchange());
        o.setChangeStamp(LocalDateTime.now());
        System.out.println("- " + o);
    }

    @Override
    public void cancel(Order order) {
        System.out.println("cancel:");
        if(store.containsKey(order.getId())) {
            store.remove(order.getId());
            System.out.println("- " + order.getId() + " cancelled");
        }
    }

    @Override
    public void close(int id) {
        System.out.println("close:");
        if(store.containsKey(id)) {
            Order order = store.get(id);
            store.remove(id);
            closedOrders.add(order);
            System.out.println("- " + order.getId() + " closed");
        }
    }

    @Override
    public Order query(int id) {
        System.out.println("close:");
        if(store.containsKey(id)) {
            Order order = store.get(id);
            return order;
        }
        return null;
    }

    @Override
    public Order queryClosed(int id) {
        if(closedOrders.size() > 0) {
            closedOrders.parallelStream().filter(o->o.getId()==id).findFirst();
        }
        return null;
    }

    @Override
    public void execute(int id) {
        System.out.println("oms.execute:");
        if(store.containsKey(id)) {
            Order order = store.get(id);
            executor.execute(order);
        }
    }
}
