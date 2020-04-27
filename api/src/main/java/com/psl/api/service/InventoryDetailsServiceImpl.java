package com.psl.api.service;

import com.psl.api.bean.InventoryDetails;
import com.psl.api.dao.InventoryDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("inventoryDetailsService")
public class InventoryDetailsServiceImpl implements  InventoryDetailsService{

    @Autowired
    private InventoryDetailsDao inventoryDetailsDao;

    @Override
    public List<InventoryDetails> getAllInventoryDetails() {
        List<InventoryDetails> inventoryDetailsList = inventoryDetailsDao.getAllInventoryDetails();
        if(inventoryDetailsList == null)
            throw new NoSuchElementException();
        return inventoryDetailsList;
    }

    @Override
    public InventoryDetails addInventoryDetails(InventoryDetails inventoryDetails) {
        return inventoryDetailsDao.addInventoryDetails(inventoryDetails);
    }

    @Override
    public InventoryDetails updateInventoryDetails(InventoryDetails inventoryDetails) {
        InventoryDetails updatedInventoryDetails = inventoryDetailsDao.updateInventoryDetails(inventoryDetails);
        if(updatedInventoryDetails == null)
            throw new NoSuchElementException();
        return updatedInventoryDetails;
    }

    @Override
    public InventoryDetails getInventoryDetailsById(int inventoryId) {
        InventoryDetails inventoryDetails = inventoryDetailsDao.getInventoryDetailsById(inventoryId);
        if(inventoryDetails == null)
            throw new NoSuchElementException();
        return inventoryDetails;
    }

    @Override
    public boolean deleteInventoryDetailsById(int inventoryId) {
        boolean isDeleted = inventoryDetailsDao.deleteInventoryDetailsById(inventoryId);
        if(isDeleted)
            return isDeleted;
        throw new NoSuchElementException();
    }
}
