package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.GourmetWorldFoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("gourmetWorldFoodService")
public class GourmetWorldFoodServiceImpl implements GourmetWorldFoodService{

    @Autowired
    private GourmetWorldFoodDao gourmetWorldFoodDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = gourmetWorldFoodDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = gourmetWorldFoodDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return gourmetWorldFoodDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = gourmetWorldFoodDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = gourmetWorldFoodDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

