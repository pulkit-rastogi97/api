package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.KitchenGardenPetsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("kitchenGardenPetsService")
public class KitchenGardenPetsServiceImpl implements  ProductService{

    @Autowired
    private KitchenGardenPetsDao kitchenGardenPetsDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = kitchenGardenPetsDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = kitchenGardenPetsDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return kitchenGardenPetsDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = kitchenGardenPetsDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = kitchenGardenPetsDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}

