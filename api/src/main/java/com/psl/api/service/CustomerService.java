package com.psl.api.service;

import com.psl.api.bean.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer addCustomer(Customer customer);
    public boolean deleteCustomerById(int customerId);
    public Customer updateCustomer(Customer customer);
    public Customer getCustomerById(int customerId);
}
