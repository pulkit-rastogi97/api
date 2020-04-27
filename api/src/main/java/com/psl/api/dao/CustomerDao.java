package com.psl.api.dao;


import com.psl.api.bean.Customer;

import java.util.List;

public interface CustomerDao {

    public List<Customer> getAllCustomers();
    public Customer addCustomer(Customer customer);
    public boolean deleteCustomerById(int customerId);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(int customerId);

}
