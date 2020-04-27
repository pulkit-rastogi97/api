package com.psl.api.dao;

import com.psl.api.bean.OrderStatus;
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

@Repository("orderStatusDao")
public class OrderStatusDaoImpl extends JdbcDaoSupport implements OrderStatusDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<OrderStatus> getAllOrderStatus() {
        sql = "SELECT * FROM order_status";
        try {

            return this.getJdbcTemplate().query(sql, new RowMapper<OrderStatus>() {

                @Override
                public OrderStatus mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderStatus orderStatus = new OrderStatus();
                    orderStatus.setStatusId(resultSet.getInt("status_id"));
                    orderStatus.setOrderStatus(resultSet.getString("order_status"));
                    return orderStatus;
                }


            });

        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public OrderStatus getOrderStatusById(int status_id) {
        sql = "SELECT order_status FROM order_status WHERE status_id = " + status_id;
        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<OrderStatus>() {


                @Override
                public OrderStatus mapRow(ResultSet resultSet, int row) throws SQLException {
                    OrderStatus orderStatus = new OrderStatus();
                    orderStatus.setStatusId(resultSet.getInt("status_id"));
                    orderStatus.setOrderStatus(resultSet.getString("order_status"));
                    return orderStatus;
                }

            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }

    }
}
