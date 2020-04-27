package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.BabyCareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("babyCareService")
public class BabyCareServiceImpl implements  BabyCareService{

    @Autowired
    private BabyCareDao babyCareDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = babyCareDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = babyCareDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return babyCareDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = babyCareDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = babyCareDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

