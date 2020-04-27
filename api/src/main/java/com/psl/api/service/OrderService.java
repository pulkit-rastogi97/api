package com.psl.api.service;

import com.psl.api.bean.Order;
import com.psl.api.bean.OrderItems;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public Order getOrderById(int orderId);
    public boolean deleteOrderById(int orderId);

}
