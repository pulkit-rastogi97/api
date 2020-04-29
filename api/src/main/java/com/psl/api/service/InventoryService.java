package com.psl.api.service;

import com.psl.api.bean.Inventory;

import java.util.List;

public interface InventoryService {
    public List<Inventory> getAllItems();
    public Inventory addToInventory(Inventory inventory);
    public Inventory updateInventory(Inventory inventory);
    public boolean deleteFromInventory(int inventoryId);
}
