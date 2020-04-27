package com.psl.api.service;

import com.psl.api.bean.*;
import com.psl.api.dao.TableProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private OrderItemsService orderItemsService;
    @Autowired
    private OrderDetailsService orderDetailsService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TableProductsDao tableProductsDao;

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<Order>();

        //Get All Order Details
        List<OrderDetails> orderDetailsList = orderDetailsService.getAllOrderDetails();

        //Loop over the list
        for(OrderDetails orderDetails : orderDetailsList)
        {
            //Create Order object
            Order order = new Order();

            //Call get customerById
            order.setCustomer(customerService.getCustomerById(orderDetails.getCustomerId()));

            //Call get order status
            order.setOrderStatus(orderStatusService.getOrderStatusById(orderDetails.getStatusId()).getOrderStatus());

            //Call get Order Amount
            order.setOrderAmount(orderDetails.getOrderAmount());

            //Call get all products with respect to table name
            List<Product> products = new ArrayList<Product>();

            //Call get List of all orderedProducts
            List<OrderItems> orderItemsList = orderItemsService.getOrderItemsByOrderId(orderDetails.getOrderId());
            List<OrderedProduct> orderedProductList = new ArrayList<OrderedProduct>();
            for(OrderItems orderItems : orderItemsList)
            {
                OrderedProduct orderedProduct = new OrderedProduct();
                products = tableProductsDao.getProductsByTable(categoryService.getCategoryById(orderItems.getCategoryId()).getCategoryTable());

                for(Product product : products)
                {
                    if(product.getProductId() == orderItems.getProductId())
                    {
                        orderedProduct.setProductName(product.getProductName());
                        break;
                    }
                }

                orderedProduct.setQuantity(orderItems.getQuantity());
                orderedProduct.setProductUnitPrice(orderItems.getProductUnitPrice());
                orderedProduct.setProductAmount(orderItems.getQuantity() * orderItems.getProductUnitPrice());

                //Adding all the orderedProducts to the orderProductsList
                orderedProductList.add(orderedProduct);
            }

            //Setting all the orderedproducts to the order
            order.setProducts(orderedProductList);

            //Add order to the orders list
            orders.add(order);
        }
        return orders;
    }

    @Override
    public Order addOrder(Order order) {

        //TODO : in database


        return null;
    }

    @Override
    public Order updateOrder(Order order) {

        //TODO : in database

        return null;
    }

    @Override
    public Order getOrderById(int orderId) {

        List<Order> orders = getAllOrders();

        for(Order order : orders)
        {
            if(order.getOrderId() == orderId)
                return order;
        }
        return null;
    }

    @Override
    public boolean deleteOrderById(int orderId) {

        //TODO : in database

        return false;
    }

}
