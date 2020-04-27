package com.psl.api.controller;

import com.psl.api.bean.OrderItems;
import com.psl.api.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping
    public ResponseEntity<List<OrderItems>> listAll(){
        try{
            List<OrderItems> orderItemsList = orderItemsService.getAllOrderItems();
            return new ResponseEntity<List<OrderItems>>(orderItemsList, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<OrderItems>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping(value = "{order_id}/{category_id}/{product_id}", method = RequestMethod.GET)
    public ResponseEntity<OrderItems> get(@PathVariable Integer order_id, @PathVariable Integer category_id, @PathVariable Integer product_id){
        try {
            OrderItems orderItems = orderItemsService.getOrderItemsById(order_id,category_id,product_id);
            return new ResponseEntity<OrderItems>(orderItems, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrderItems>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderItems> create(@RequestBody final OrderItems orderItems){
        OrderItems insertedOrderItems = orderItemsService.addOrderItems(orderItems);
        return new ResponseEntity<OrderItems>(insertedOrderItems,HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{order_id}/{category_id}/{product_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer order_id, @PathVariable Integer category_id, @PathVariable Integer product_id){
        try {
            boolean isDeleted = orderItemsService.deleteOrderItemsById(order_id,category_id,product_id);
            return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping(value = "{order_id}/{category_id}/{product_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer order_id, @PathVariable Integer category_id, @PathVariable Integer product_id, @RequestBody OrderItems orderItems){
        try {
            OrderItems updatedOrderItems = orderItemsService.updateOrderItems(orderItems);
            return new ResponseEntity<OrderItems>(updatedOrderItems, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<OrderItems>(HttpStatus.NOT_FOUND);
        }

    }
}
