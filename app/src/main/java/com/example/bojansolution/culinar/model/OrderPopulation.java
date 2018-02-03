package com.example.bojansolution.culinar.model;

/**
 * Created by bojan solution on 02/02/2018.
 */

public class OrderPopulation {
    private int orderId;
    private String orderString;
    private String orderStatus;

    public OrderPopulation(int orderId, String orderString) {
        this.orderId = orderId;
        this.orderString = orderString;
    }

    public int getOrderId() {
        return orderId;
    }
    public String getOrderString() {
        return orderString;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
}
