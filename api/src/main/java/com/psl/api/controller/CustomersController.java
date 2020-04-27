package com.psl.api.controller;

import com.psl.api.bean.Customer;
import com.psl.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> listAll(){
        try{
            List<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> get(@PathVariable Integer id){
        try {
            Customer customer = customerService.getCustomerById(id);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> create(@RequestBody final Customer customer){
        Customer insertedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(insertedCustomer,HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        try {
            boolean isDeleted = customerService.deleteCustomerById(id);
            return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Customer customer){
        try {
            Customer updatedCustomer = customerService.updateCustomer(customer);
            return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

    }

}
