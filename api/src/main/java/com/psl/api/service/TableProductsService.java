package com.psl.api.service;

import com.psl.api.bean.Product;

import java.util.List;

public interface TableProductsService {
    public List<Product> getProductsByTable(String table_name);
    public Product getProductFromTable(String table_name, int productId);
}
