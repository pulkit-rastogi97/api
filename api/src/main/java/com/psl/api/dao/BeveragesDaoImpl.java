package com.psl.api.dao;

import com.psl.api.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("beveragesDao")
public class BeveragesDaoImpl extends JdbcDaoSupport implements BeveragesDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        this.setDataSource(dataSource);
    }

    String sql;
    String tableName = "beverages";

    @Override
    public boolean deleteProduct(int productId) {

        sql = "DELETE FROM " + tableName + " WHERE product_id = "+productId;

        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        return isDeleted;

    }

    @Override
    public List<Product> getAllProducts() {

        sql = "SELECT * FROM " + tableName;

        try {

            return this.getJdbcTemplate().query(sql, new RowMapper<Product>() {

                @Override
                public Product mapRow(ResultSet resultSet, int row) throws SQLException {
                    Product product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductDesc(resultSet.getString("product_desc"));
                    return product;
                }


            });

        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public Product addProduct(Product product) {

        sql = "INSERT INTO " + tableName + " product(product_name, product_desc) VALUES('" + product.getProductName() + "', '" + product.getProductDesc() + "')";

        this.getJdbcTemplate().update(sql);

        return product;



    }

    @Override
    public Product updateProduct(Product product) {

        sql = "UPDATE " + tableName + " SET product_name = '" + product.getProductName() + "', product_desc = '" + product.getProductDesc() + "' WHERE product_id = " + product.getProductId();

        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        if(isUpdated)
            return product;

        return null;
    }

    @Override
    public Product getProductById(int productId) {

        sql = "SELECT * from " + tableName + " WHERE product_id = " + productId;

        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<Product>() {


                @Override
                public Product mapRow(ResultSet resultSet, int row) throws SQLException {

                    Product product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductDesc(resultSet.getString("product_desc"));

                    return product;
                }

            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }


    }

}

