package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.FoodgrainsOilMasalaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("foodgrainsOilMasalaService")
public class FoodgrainsOilMasalaServiceImpl implements  FoodgrainsOilMasalaService{

    @Autowired
    private FoodgrainsOilMasalaDao foodgrainsOilMasalaDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = foodgrainsOilMasalaDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = foodgrainsOilMasalaDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return foodgrainsOilMasalaDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = foodgrainsOilMasalaDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = foodgrainsOilMasalaDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

