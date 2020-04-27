package com.psl.api.dao;

import com.psl.api.bean.Customer;
import com.psl.api.bean.OrderItems;

import java.util.List;

public interface OrderItemsDao {

    public List<OrderItems> getAllOrderItems();
    public OrderItems addOrderItems(OrderItems orderItems);
    public OrderItems updateOrderItems(OrderItems orderItems);
    public OrderItems getOrderItemsById(int orderId, int categoryId, int productId);
    public boolean deleteOrderItemsById(int orderId, int categoryId, int productId);
}
