package com.psl.api.dao;

import java.util.List;

import com.psl.api.bean.Category;

public interface CategoryDao {

    public boolean deleteCategory(int categoryId);
    public List<Category> getAllCategories();
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategoryById(int categoryId);


}
