package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.bean.Product;
import com.psl.api.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("productService")
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public boolean deleteProduct(int productId) {

        boolean isDeleted = productDao.deleteProduct(productId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> categories = productDao.getAllProducts();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Product addProduct(Product product) {

        return productDao.addProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {


        Product updatedProduct = productDao.updateProduct(product);

        if(updatedProduct == null)
        {
            throw new NoSuchElementException();
        }

        return updatedProduct;
    }

    @Override
    public Product getProductById(int productId) throws NoSuchElementException{

        Product product = productDao.getProductById(productId);

        if(product == null)
        {
            throw new NoSuchElementException();
        }

        return product;
    }
}
