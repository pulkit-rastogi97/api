package com.psl.api.dao;

import com.psl.api.bean.Category;
import com.psl.api.bean.Customer;
import com.psl.api.bean.Customer;
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

@Repository("customerDao")
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialiaze() {
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<Customer> getAllCustomers() {
        sql = "SELECT * FROM customer";

        try {


            return this.getJdbcTemplate().query(sql, new RowMapper<Customer>() {

                @Override
                public Customer mapRow(ResultSet resultSet, int row) throws SQLException {
                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("customer_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                    customer.setCustomerContact(resultSet.getLong("customer_contact"));

                    return customer;
                }
            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        sql = "INSERT INTO customer(customer_name, customer_address, customer_contact) VALUES = '" + customer.getCustomerName() + "' , '" + customer.getCustomerAddress() + "', " + customer.getCustomerContact() + " )";

        this.getJdbcTemplate().update(sql);

        return customer;
    }

    @Override
    public boolean deleteCustomerById(int customerId) {

        sql = "DELETE FROM customer WHERE customer_id = "+customerId;

        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        return isDeleted;
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        sql = "UPDATE customer SET customer_name = '" + customer.getCustomerName() + "', customer_address = '" + customer.getCustomerAddress() + "', customer_contact = " + customer.getCustomerContact() + " WHERE customer_id = " + customer.getCustomerId();

        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        if(isUpdated)
            return customer;

        return null;

    }

    @Override
    public Customer getCustomerById(int customerId) {
        sql = "SELECT * from customer WHERE customer_id = " + customerId;

        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<Customer>() {


                @Override
                public Customer mapRow(ResultSet resultSet, int row) throws SQLException {

                    Customer customer = new Customer();
                    customer.setCustomerId(resultSet.getInt("customer_id"));
                    customer.setCustomerName(resultSet.getString("customer_name"));
                    customer.setCustomerAddress(resultSet.getString("customer_address"));
                    customer.setCustomerContact(resultSet.getLong("customer_contact"));

                    return customer;
                }

            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }
}
