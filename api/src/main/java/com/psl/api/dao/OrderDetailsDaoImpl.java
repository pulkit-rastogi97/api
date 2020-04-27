package com.psl.api.dao;

import com.psl.api.bean.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("orderDetailsDao")
public class OrderDetailsDaoImpl extends JdbcDaoSupport implements OrderDetailsDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        sql = "SELECT * FROM order_details";
        try {
            return this.getJdbcTemplate().query(sql, new RowMapper<OrderDetails>() {

                @Override
                public OrderDetails mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderId(resultSet.getInt("order_id"));
                    orderDetails.setCustomerId(resultSet.getInt("customer_id"));
                    orderDetails.setStatusId(resultSet.getInt("status_id"));
                    orderDetails.setOrderDate(resultSet.getDate("order_date"));
                    orderDetails.setOrderAmount(resultSet.getDouble("order_amount"));
                    return orderDetails;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        sql = "INSERT INTO order_details(customer_id, status_id, order_amount, order_date) VALUES ( " + orderDetails.getCustomerId() + "," + orderDetails.getStatusId() + ","+ orderDetails.getOrderAmount() + "," + orderDetails.getOrderDate() + " )";
        this.getJdbcTemplate().update(sql);
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
        sql = "UPDATE order_details SET order_date = " + orderDetails.getOrderDate() + ", order_amount = " + orderDetails.getOrderAmount() + ", status_id = " + orderDetails.getStatusId() + ", customer_id = " + orderDetails.getCustomerId() +" WHERE order_id = " + orderDetails.getOrderId();
        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        if(isUpdated)
            return orderDetails;
        else
            return null;
    }

    @Override
    public OrderDetails getOrderDetailsById(int orderId) {

        sql = "SELECT * FROM order_details WHERE order_id = " + orderId;
        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<OrderDetails>() {

                @Override
                public OrderDetails mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderId(resultSet.getInt("order_id"));
                    orderDetails.setOrderAmount(resultSet.getDouble("order_amount"));
                    orderDetails.setOrderDate(resultSet.getDate("order_date"));
                    orderDetails.setCustomerId(resultSet.getInt("customer_id"));
                    orderDetails.setStatusId(resultSet.getInt("status_id"));
                    return orderDetails;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }


    @Override
    public boolean deleteOrderDetailsById(int orderId) {
        sql = "DELETE FROM order_details WHERE order_id = " + orderId;
        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        return isDeleted;
    }
}


