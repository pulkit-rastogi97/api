package com.psl.api.service;

import com.psl.api.bean.OrderDetails;

import java.util.List;

public interface OrderDetailsService {
    public List<OrderDetails> getAllOrderDetails();
    public OrderDetails addOrderDetails(OrderDetails orderDetails);
    public OrderDetails updateOrderDetails(OrderDetails orderDetails);
    public OrderDetails getOrderDetailsById(int orderId);
    public boolean deleteOrderDetailsById(int orderId);
}
