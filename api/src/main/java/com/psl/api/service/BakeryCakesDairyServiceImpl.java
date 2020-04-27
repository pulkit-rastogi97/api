package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.BakeryCakesDairyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("bakeryCakesService")
public class BakeryCakesDairyServiceImpl implements  BakeryCakesDairyService{

    @Autowired
    private BakeryCakesDairyDao bakeryCakesDairyDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = bakeryCakesDairyDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = bakeryCakesDairyDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return bakeryCakesDairyDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = bakeryCakesDairyDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = bakeryCakesDairyDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

