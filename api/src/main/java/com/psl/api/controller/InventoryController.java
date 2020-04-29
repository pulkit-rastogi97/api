package com.psl.api.controller;

import com.psl.api.bean.Inventory;
import com.psl.api.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Inventory>> listAll(){
        try{
            List<Inventory> inventories = inventoryService.getAllItems();
            return new ResponseEntity<List<Inventory>>(inventories, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<Inventory>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Inventory> create(@RequestBody final Inventory inventory){
        Inventory insertedInventory = inventoryService.addToInventory(inventory);
        return new ResponseEntity<Inventory>(insertedInventory,HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        try {
            boolean isDeleted = inventoryService.deleteFromInventory(id);
            return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Inventory> update(@PathVariable Integer id, @RequestBody Inventory inventory){
        try {
            Inventory updatedInventory = inventoryService.updateInventory(inventory);
            return new ResponseEntity<Inventory>(updatedInventory, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }

    }

}
