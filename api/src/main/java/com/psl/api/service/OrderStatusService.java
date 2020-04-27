package com.psl.api.service;

import com.psl.api.bean.OrderStatus;

import java.util.List;

public interface OrderStatusService {
    public List<OrderStatus> getAllOrderStatus();
    public OrderStatus getOrderStatusById(int status_id);
}
