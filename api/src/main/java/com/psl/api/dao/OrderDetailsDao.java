package com.psl.api.dao;

import com.psl.api.bean.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {

    public List<OrderDetails> getAllOrderDetails();
    public OrderDetails addOrderDetails(OrderDetails orderDetails);
    public OrderDetails updateOrderDetails(OrderDetails orderDetails);
    public OrderDetails getOrderDetailsById(int orderId);
    public boolean deleteOrderDetailsById(int orderId);
}
