package io.codej.designpatterns.creational.builder;

import io.codej.designpatterns.behavioral.template.Order;

public class AccountBuilder implements Builder {
    private Order order;

    public AccountBuilder(Order order) {
        this.order = order;
    }

    @Override
    public Object build() {
        System.out.println(":accountBuilder");
        String user = this.order.getUser();
        String desk = this.order.getDesk();
        System.out.println("{user:" + user + ", desk:" + desk + "}");
        String acc = fetchAccount(user, desk);
        System.out.println("accout:" + acc);
        this.order.setAccount(acc);
        return this.order;
    }

    private String fetchAccount(String user, String desk) {
        return user+":"+desk+":42";
    }
}
