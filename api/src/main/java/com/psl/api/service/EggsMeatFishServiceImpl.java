package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.EggsMeatFishDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("eggsMeatFishService")
public class EggsMeatFishServiceImpl implements  EggsMeatFishService{

    @Autowired
    private EggsMeatFishDao eggsMeatFishDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = eggsMeatFishDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = eggsMeatFishDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return eggsMeatFishDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = eggsMeatFishDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = eggsMeatFishDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

