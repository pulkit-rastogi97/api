package com.psl.api.dao;

import com.psl.api.bean.Product;

import java.util.List;

public interface FruitsVegetablesDao {
    public boolean deleteProduct(int productId);
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product getProductById(int productId);
}
