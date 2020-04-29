package com.psl.api.service;

import com.psl.api.bean.Category;
import com.psl.api.bean.Inventory;
import com.psl.api.bean.InventoryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("inventoryService")
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    public InventoryDetailsService inventoryDetailsService;
    @Autowired
    public CategoryService categoryService;
    @Autowired
    public TableProductsService tableProductsService;


    @Override
    public List<Inventory> getAllItems() {
        List<InventoryDetails> inventoryDetailsList = inventoryDetailsService.getAllInventoryDetails();
        if(inventoryDetailsList == null || inventoryDetailsList.isEmpty())
        {
            throw new NoSuchElementException();
        }

        List<Inventory> inventories = new ArrayList<>();
        for(InventoryDetails inventoryDetails : inventoryDetailsList)
        {
            Inventory inventory = new Inventory();

            //InventoryId directly from inventory_id
            inventory.setInventory_id(inventoryDetails.getInventoryId());

            //Category Map
            Map<Integer,String> category = new HashMap<>();
            Category categoryToBePut = categoryService.getCategoryById(inventoryDetails.getCategoryId());
            category.put(inventoryDetails.getCategoryId(),categoryToBePut.getCategoryName());

            //Category Map which is created added
            inventory.setCategory(category);

            //Product Map
            Map<Integer,String> product = new HashMap<>();
            product.put(inventoryDetails.getProductId(),tableProductsService.getProductFromTable(categoryToBePut.getCategoryTable(),inventoryDetails.getProductId()).getProductName());

            //Product map added.
            inventory.setProduct(product);

            //Manufacturing Date
            inventory.setMfg_date(inventoryDetails.getManufacturingDate());

            //Quantity
            inventory.setQuantity(inventoryDetails.getQuantity());

            //Unit Price
            inventory.setUnit_price(inventoryDetails.getUnitPrice());

            //Adding to the list
            inventories.add(inventory);
        }

        return inventories;
    }

    @Override
    public Inventory addToInventory(Inventory inventory) {

        InventoryDetails inventoryDetails = new InventoryDetails();

        inventoryDetails.setUnitPrice(inventory.getUnit_price());
        inventoryDetails.setQuantity(inventory.getQuantity());

        for(Map.Entry<Integer, String> entrySet : inventory.getCategory().entrySet())
            inventoryDetails.setCategoryId(entrySet.getKey());

        for(Map.Entry<Integer, String> entrySet : inventory.getProduct().entrySet())
            inventoryDetails.setProductId(entrySet.getKey());

        inventoryDetails.setManufacturingDate(inventory.getMfg_date());

       InventoryDetails inventoryDetails1 = inventoryDetailsService.addInventoryDetails(inventoryDetails);

       inventory.setInventory_id(inventoryDetails1.getInventoryId());

        return inventory;
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {

        InventoryDetails inventoryDetails = new InventoryDetails();

        inventoryDetails.setUnitPrice(inventory.getUnit_price());
        inventoryDetails.setQuantity(inventory.getQuantity());

        for(Map.Entry<Integer, String> entrySet : inventory.getCategory().entrySet())
            inventoryDetails.setCategoryId(entrySet.getKey());

        for(Map.Entry<Integer, String> entrySet : inventory.getProduct().entrySet())
            inventoryDetails.setProductId(entrySet.getKey());

        inventoryDetails.setManufacturingDate(inventory.getMfg_date());

        InventoryDetails inventoryDetails1 = inventoryDetailsService.updateInventoryDetails(inventoryDetails);

        return inventory;
    }

    @Override
    public boolean deleteFromInventory(int inventoryId) {

        boolean isDeleted = inventoryDetailsService.deleteInventoryDetailsById(inventoryId);
        return isDeleted;
    }
}
