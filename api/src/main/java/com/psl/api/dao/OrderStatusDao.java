package com.psl.api.dao;

import com.psl.api.bean.OrderStatus;

import java.util.List;

public interface OrderStatusDao {
    public List<OrderStatus> getAllOrderStatus();
    public OrderStatus getOrderStatusById(int status_id);
}
