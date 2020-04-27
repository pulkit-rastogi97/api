package com.psl.api.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.psl.api.bean.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends JdbcDaoSupport implements CategoryDao{

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialiaze() {
        this.setDataSource(dataSource);
    }

    String sql;
    String tableName = "category";
    @Override
    public boolean deleteCategory(int categoryId) {

        sql = "DELETE FROM category WHERE category_id = "+categoryId;

        boolean isDeleted = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        return isDeleted;

    }

    @Override
    public List<Category> getAllCategories() {

        sql = "SELECT * FROM " + tableName;

        try {

            return this.getJdbcTemplate().query(sql, new RowMapper<Category>() {

                @Override
                public Category mapRow(ResultSet resultSet, int row) throws SQLException {
                    Category category = new Category();
                    category.setCategoryId(resultSet.getInt("category_id"));
                    category.setCategoryName(resultSet.getString("category_name"));
                    category.setCategoryDesc(resultSet.getString("category_desc"));
                    category.setCategoryTable(resultSet.getString("category_table"));

                    return category;
                }


            });

        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    @Override
    public Category addCategory(Category category) {

        sql = "INSERT INTO category(category_name, category_desc, category_table) VALUES('" + category.getCategoryName() + "', '" + category.getCategoryDesc() + "', '" + category.getCategoryTable() + "')";

        this.getJdbcTemplate().update(sql);

        return category;



    }

    @Override
    public Category updateCategory(Category category) {

        sql = "UPDATE category SET category_name = '" + category.getCategoryName() + "', category_desc = '" + category.getCategoryDesc() + "', category_table = '" + category.getCategoryTable() + "' WHERE category_id = " + category.getCategoryId();

        boolean isUpdated = this.getJdbcTemplate().update(sql) == 1 ? true : false;

        if(isUpdated)
            return category;

        return null;
    }

    @Override
    public Category getCategoryById(int categoryId) {

        sql = "SELECT * from category WHERE category_id = " + categoryId;

        try {

            return this.getJdbcTemplate().queryForObject(sql, new RowMapper<Category>() {


                @Override
                public Category mapRow(ResultSet resultSet, int row) throws SQLException {

                        Category category = new Category();
                        category.setCategoryId(resultSet.getInt("category_id"));
                        category.setCategoryName(resultSet.getString("category_name"));
                        category.setCategoryDesc(resultSet.getString("category_desc"));
                        category.setCategoryTable(resultSet.getString("category_table"));

                        return category;
                    }

            });
        }catch(EmptyResultDataAccessException e)
        {
            return null;
        }


    }

}





