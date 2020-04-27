package com.psl.api.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.psl.api.bean.Category;

public interface CategoryService {

    public boolean deleteCategory(int categoryId);
    public List<Category> getAllCategories();
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Category getCategoryById(int categoryId);
    public String getCategoryTable(int categoryId);

}
