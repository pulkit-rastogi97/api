package com.psl.api.controller;

import com.psl.api.bean.OrderDetails;
import com.psl.api.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping
    public ResponseEntity<List<OrderDetails>> listAll(){
        try{
            List<OrderDetails> orderDetailsList = orderDetailsService.getAllOrderDetails();
            return new ResponseEntity<List<OrderDetails>>(orderDetailsList, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<OrderDetails>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetails> get(@PathVariable Integer id){
        try {
            OrderDetails orderDetails = orderDetailsService.getOrderDetailsById(id);
            return new ResponseEntity<OrderDetails>(orderDetails, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDetails> create(@RequestBody final OrderDetails orderDetails){
        OrderDetails insertedOrderDetails = orderDetailsService.addOrderDetails(orderDetails);
        return new ResponseEntity<OrderDetails>(insertedOrderDetails,HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        try {
            boolean isDeleted = orderDetailsService.deleteOrderDetailsById(id);
            return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetails> update(@PathVariable Integer id,@RequestBody OrderDetails orderDetails){
        try {
            OrderDetails updatedOrderDetails = orderDetailsService.updateOrderDetails(orderDetails);
            return new ResponseEntity<OrderDetails>(updatedOrderDetails, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrderDetails>(HttpStatus.NOT_FOUND);
        }

    }

}
