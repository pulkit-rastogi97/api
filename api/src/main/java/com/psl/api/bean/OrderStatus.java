package com.psl.api.bean;

import org.springframework.stereotype.Component;

@Component
public class OrderStatus {

    private int statusId;
    private String orderStatus;

    public OrderStatus(){

    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
