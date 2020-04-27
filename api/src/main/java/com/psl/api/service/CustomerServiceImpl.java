package com.psl.api.service;

import com.psl.api.bean.Customer;
import com.psl.api.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("customerService")
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomers();
        if(customers == null)
            throw new NoSuchElementException();
        return customers;
    }

    @Override
    public Customer addCustomer(Customer customer) {
       return customerDao.addCustomer(customer);
    }

    @Override
    public boolean deleteCustomerById(int customerId) {
        boolean isDeleted = customerDao.deleteCustomerById(customerId);
        if(isDeleted)
            return isDeleted;
        else
            throw  new NoSuchElementException();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer updatedCustomer = customerDao.updateCustomer(customer);
        if(updatedCustomer == null)
            throw  new NoSuchElementException();
        else
            return updatedCustomer;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        if(customer ==  null)
            throw new NoSuchElementException();
        else
            return customer;
    }
}
