package com.psl.api.service;

import com.psl.api.bean.Product;
import com.psl.api.dao.TableProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("tableProductsService")
public class TableProductsServiceImpl implements TableProductsService{

    @Autowired
    private TableProductsDao tableProductsDao;

    @Override
    public List<Product> getProductsByTable(String table_name) {
        List<Product> products = tableProductsDao.getProductsByTable(table_name);
        if(products.isEmpty())
        {
            throw new NoSuchElementException();
        }
        return products;
    }

    @Override
    public Product getProductFromTable(String table_name, int productId) {
        Product product = tableProductsDao.getProductFromTable(table_name,productId);
        if(product == null)
        {
            throw new NoSuchElementException();
        }
        return product;
    }
}
