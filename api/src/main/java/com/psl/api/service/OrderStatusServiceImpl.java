package com.psl.api.service;

import com.psl.api.bean.OrderStatus;
import com.psl.api.dao.OrderStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("orderStatusService")
public class OrderStatusServiceImpl implements  OrderStatusService{

    @Autowired
    private OrderStatusDao orderStatusDao;

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        List<OrderStatus> orderStatuses = orderStatusDao.getAllOrderStatus();
        if(orderStatuses == null)
            throw new NoSuchElementException();
        return orderStatuses;
    }

    @Override
    public OrderStatus getOrderStatusById(int status_id) {
        OrderStatus orderStatus = orderStatusDao.getOrderStatusById(status_id);
        if(orderStatus == null )
        {
            throw new NoSuchElementException();
        }
        return orderStatus;
    }
}
