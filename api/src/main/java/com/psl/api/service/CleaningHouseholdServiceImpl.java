package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.CleaningHouseholdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service("cleaningHouseholdService")
public class CleaningHouseholdServiceImpl implements  CleaningHouseholdService{

    @Autowired
    private CleaningHouseholdDao cleaningHouseholdDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = cleaningHouseholdDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = cleaningHouseholdDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return cleaningHouseholdDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = cleaningHouseholdDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = cleaningHouseholdDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

