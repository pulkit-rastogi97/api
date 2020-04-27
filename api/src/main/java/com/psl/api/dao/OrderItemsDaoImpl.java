package com.psl.api.dao;

import com.psl.api.bean.OrderItems;
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

@Repository("orderItemsDao")
public class OrderItemsDaoImpl extends JdbcDaoSupport implements OrderItemsDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialiaze() {
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<OrderItems> getAllOrderItems() {
        sql = "SELECT * FROM order_items";
        try {
            return this.getJdbcTemplate().query(sql, new RowMapper<OrderItems>() {

                @Override
                public OrderItems mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderItems orderItems = new OrderItems();
                    orderItems.setOrderId(resultSet.getInt("order_id"));
                    orderItems.setCategoryId(resultSet.getInt("category_id"));
                    orderItems.setProductId(resultSet.getInt("product_id"));
                    orderItems.setProductUnitPrice(resultSet.getDouble("product_unit_price"));
                    orderItems.setQuantity(resultSet.getInt("quantity"));
                    orderItems.setProductAmount(resultSet.getDouble("product_amount"));
                    return orderItems;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public OrderItems addOrderItems(OrderItems orderItems) {
        sql = "INSERT INTO order_items VALUES ( " + orderItems.getOrderId() + "," + orderItems.getCategoryId() + "," + orderItems.getProductId() + "," + orderItems.getQuantity() + "," + orderItems.getProductUnitPrice() + "," + orderItems.getProductAmount() + " )";
        this.getJdbcTemplate().update(sql);
        return orderItems;
    }

    @Override
    public OrderItems updateOrderItems(OrderItems orderItems) {
        sql = "UPDATE order_items SET product_unit_price = " + orderItems.getProductUnitPrice() + ", quantity = " + orderItems.getQuantity() + ", product_amount = " + orderItems.getProductAmount() + " WHERE order_id = " + orderItems.getOrderId() + " AND category_id = " + orderItems.getCategoryId() + " AND product_id = " + orderItems.getProductId();
        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        if(isUpdated)
            return orderItems;
        else
            return null;
    }

    @Override
    public OrderItems getOrderItemsById(int orderId, int categoryId, int productId) {

        sql = "SELECT * FROM order_items WHERE order_id = " + orderId + " AND category_id = " + categoryId + " AND product_id = " + productId;
        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<OrderItems>() {


                @Override
                public OrderItems mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderItems orderItems = new OrderItems();
                    orderItems.setOrderId(resultSet.getInt("order_id"));
                    orderItems.setCategoryId(resultSet.getInt("category_id"));
                    orderItems.setProductId(resultSet.getInt("product_id"));
                    orderItems.setProductUnitPrice(resultSet.getDouble("product_unit_price"));
                    orderItems.setQuantity(resultSet.getInt("quantity"));
                    orderItems.setProductAmount(resultSet.getDouble("product_amount"));
                    return orderItems;
                }
        });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }


    @Override
    public boolean deleteOrderItemsById(int orderId, int categoryId, int productId) {
        sql = "DELETE FROM order_items WHERE order_id = " + orderId + " AND category_id = " + categoryId + " AND product_id = " + productId;
        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;
        return isDeleted;
    }
}
