package com.psl.api.service;

import com.psl.api.bean.OrderDetails;
import com.psl.api.dao.OrderDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements  OrderDetailsService{

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        List<OrderDetails> orderDetailsList = orderDetailsDao.getAllOrderDetails();
        if(orderDetailsList == null)
            throw new NoSuchElementException();
        return orderDetailsList;
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        return orderDetailsDao.addOrderDetails(orderDetails);
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
        OrderDetails updatedOrderDetails = orderDetailsDao.updateOrderDetails(orderDetails);
        if( updatedOrderDetails == null)
            throw new NoSuchElementException();
        return updatedOrderDetails;
    }

    @Override
    public OrderDetails getOrderDetailsById(int orderId) {
        OrderDetails orderDetails = orderDetailsDao.getOrderDetailsById(orderId);
        if(orderDetails == null)
            throw new NoSuchElementException();
        return orderDetails;
    }

    @Override
    public boolean deleteOrderDetailsById(int orderId) {
        boolean isDeleted = orderDetailsDao.deleteOrderDetailsById(orderId);
        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }
}
