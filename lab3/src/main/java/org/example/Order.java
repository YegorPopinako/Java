package org.example;

import java.util.List;

public class Order {
    private static int orderIdCounter = 1;

    private int orderId;
    private List<Product> products;
    private Status status;


    public enum Status {
        PENDING,
        CANCELED,
        COMPLETED
    }

    public Order(List<Product> products) {
        this.orderId = orderIdCounter++;
        this.products = products;
        this.status = Status.PENDING;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
