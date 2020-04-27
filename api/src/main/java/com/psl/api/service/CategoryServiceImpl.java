package com.psl.api.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.api.bean.Category;
import com.psl.api.dao.CategoryDao;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean deleteCategory(int categoryId) {

        boolean isDeleted = categoryDao.deleteCategory(categoryId);

        if(isDeleted)
            return isDeleted;
        else
            throw new NoSuchElementException();
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryDao.getAllCategories();
        if(categories == null)
            throw new NoSuchElementException();
        return categories;
    }

    @Override
    public Category addCategory(Category category) {

        return categoryDao.addCategory(category);
    }

    @Override
    public Category updateCategory(Category category) {


        Category updatedCategory = categoryDao.updateCategory(category);

        if(updatedCategory == null)
        {
            throw new NoSuchElementException();
        }

        return updatedCategory;
    }

    @Override
    public Category getCategoryById(int categoryId) throws NoSuchElementException{

        Category category = categoryDao.getCategoryById(categoryId);

        if(category == null)
        {
            throw new NoSuchElementException();
        }

        return category;
    }

    @Override
    public String getCategoryTable(int categoryId) {
       Category category = getCategoryById(categoryId);
       return category.getCategoryTable();
    }
}
