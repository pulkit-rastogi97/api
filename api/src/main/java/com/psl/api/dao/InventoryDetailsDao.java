package com.psl.api.dao;

import com.psl.api.bean.InventoryDetails;

import java.util.List;

public interface InventoryDetailsDao {
    public List<InventoryDetails> getAllInventoryDetails();
    public InventoryDetails addInventoryDetails(InventoryDetails inventoryDetails);
    public InventoryDetails updateInventoryDetails(InventoryDetails inventoryDetails);
    public InventoryDetails getInventoryDetailsById(int inventoryId);
    public boolean deleteInventoryDetailsById(int inventoryId);
}
