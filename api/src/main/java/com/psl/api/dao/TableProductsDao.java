package com.psl.api.dao;

import com.psl.api.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TableProductsDao {

    public List<Product> getProductsByTable(String table_name);
    public Product getProductFromTable(String table_name, int productId);

}
