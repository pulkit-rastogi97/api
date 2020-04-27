package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.FruitsVegetablesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("fruitsVegetablesService")
public class FruitsVegetablesServiceImpl implements  FruitsVegetablesService{

    @Autowired
    private FruitsVegetablesDao fruitsVegetablesDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = fruitsVegetablesDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = fruitsVegetablesDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return fruitsVegetablesDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = fruitsVegetablesDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = fruitsVegetablesDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

