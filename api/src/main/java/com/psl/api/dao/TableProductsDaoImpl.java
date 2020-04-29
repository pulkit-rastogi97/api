package com.psl.api.dao;

import com.psl.api.bean.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("tableProductsDao")
public class TableProductsDaoImpl extends JdbcDaoSupport implements TableProductsDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize(){
        this.setDataSource(dataSource);
    }

    String sql;

    @Override
    public List<Product> getProductsByTable(String table_name) {

        sql = "SELECT * FROM " + table_name;

        try{
            return this.getJdbcTemplate().query(sql, new RowMapper<Product>(){

                @Override
                public Product mapRow(ResultSet resultSet, int i) throws SQLException {
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
    public Product getProductFromTable(String table_name, int productId) {
        sql = "SELECT * FROM " + table_name + " WHERE product_id = " + productId;

        try{
            return this.getJdbcTemplate().query(sql, new ResultSetExtractor<Product>(){

                @Override
                public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    Product product = new Product();
                    resultSet.next();
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
