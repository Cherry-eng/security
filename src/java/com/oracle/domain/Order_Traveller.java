package com.oracle.domain;

public class Order_Traveller {
    private int id;
    private int orderId;
    private int travellerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(int travellerId) {
        this.travellerId = travellerId;
    }

    public Order_Traveller(int id, int orderId, int travellerId) {
        this.id = id;
        this.orderId = orderId;
        this.travellerId = travellerId;
    }

    public Order_Traveller() {
    }

    @Override
    public String toString() {
        return "Order_Traveller{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", travellerId=" + travellerId +
                '}';
    }
}
