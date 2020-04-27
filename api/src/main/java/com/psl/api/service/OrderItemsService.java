package com.psl.api.service;

import com.psl.api.bean.OrderItems;

import java.util.List;

public interface OrderItemsService {
    public List<OrderItems> getAllOrderItems();
    public OrderItems addOrderItems(OrderItems orderItems);
    public OrderItems updateOrderItems(OrderItems orderItems);
    public List<OrderItems> getOrderItemsByOrderId(int orderId);
    public OrderItems getOrderItemsById(int orderId, int categoryId, int productId);
    public boolean deleteOrderItemsById(int orderId, int categoryId, int productId);
}
