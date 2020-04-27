package com.psl.api.service;

import com.psl.api.bean.Product;

import java.util.List;

public interface GourmetWorldFoodService {
    public boolean deleteProduct(int productId);
    public List<Product> getAllProducts();
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product getProductById(int productId);
}
