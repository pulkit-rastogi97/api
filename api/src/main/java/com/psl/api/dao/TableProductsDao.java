package com.psl.api.dao;

import com.psl.api.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tableProductsDao")
public interface TableProductsDao {

    public List<Product> getProductsByTable(String table_name);

}
