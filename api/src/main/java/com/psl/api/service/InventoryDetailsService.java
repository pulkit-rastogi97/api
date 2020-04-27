package com.psl.api.service;

import com.psl.api.bean.InventoryDetails;

import java.util.List;

public interface InventoryDetailsService {
    public List<InventoryDetails> getAllInventoryDetails();
    public InventoryDetails addInventoryDetails(InventoryDetails inventoryDetails);
    public InventoryDetails updateInventoryDetails(InventoryDetails inventoryDetails);
    public InventoryDetails getInventoryDetailsById(int inventoryId);
    public boolean deleteInventoryDetailsById(int inventoryId);
}
