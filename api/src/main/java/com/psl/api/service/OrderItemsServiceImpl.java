package com.psl.api.service;

import com.psl.api.bean.OrderItems;
import com.psl.api.dao.OrderItemsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service("orderItemsService")
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsDao orderItemsDao;

    @Override
    public List<OrderItems> getAllOrderItems() {
        List<OrderItems> orderItemsList = orderItemsDao.getAllOrderItems();
        if(orderItemsList == null)
            throw new NoSuchElementException();
        return orderItemsList;
    }

    @Override
    public OrderItems addOrderItems(OrderItems orderItems) {
        return orderItemsDao.addOrderItems(orderItems);
    }

    @Override
    public OrderItems updateOrderItems(OrderItems orderItems) {
        OrderItems updatedOrderItems = orderItemsDao.updateOrderItems(orderItems);
        if(updatedOrderItems == null )
            throw new NoSuchElementException();
        return updatedOrderItems;
    }

    @Override
    public List<OrderItems> getOrderItemsByOrderId(int orderId) {
        List<OrderItems> orderItemsList = orderItemsDao.getAllOrderItems();
        List<OrderItems> orderItemsHavingOrderId = new ArrayList<OrderItems>();
        for(OrderItems orderItems : orderItemsList)
        {
            if(orderItems.getOrderId() == orderId)
            {
                orderItemsHavingOrderId.add(orderItems);
            }
        }
        if(orderItemsHavingOrderId.isEmpty())
            throw new NoSuchElementException();
        return orderItemsHavingOrderId;
    }

    @Override
    public OrderItems getOrderItemsById(int orderId, int categoryId, int productId) {
        OrderItems orderItems = orderItemsDao.getOrderItemsById(orderId,categoryId,productId);
        if(orderItems == null)
            throw new NoSuchElementException();
        return orderItems;
    }

    @Override
    public boolean deleteOrderItemsById(int orderId, int categoryId, int productId) {
        boolean isDeleted = orderItemsDao.deleteOrderItemsById(orderId,categoryId,productId);
        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }
}
