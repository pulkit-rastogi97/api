package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.BeautyHygieneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("beautyHygieneService")
public class BeautyHygieneServiceImpl implements  BeautyHygieneService{

    @Autowired
    private BeautyHygieneDao beautyHygieneDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = beautyHygieneDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = beautyHygieneDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return beautyHygieneDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = beautyHygieneDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = beautyHygieneDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

