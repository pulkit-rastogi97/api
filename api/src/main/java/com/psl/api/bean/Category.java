package com.psl.api.bean;

import org.springframework.stereotype.Component;

@Component
public class Category {

    private int categoryId;
    private String categoryDesc;
    private String categoryName;
    private String categoryTable;

    public Category() {
        super();
    }

    public Category(int categoryId, String categoryName, String categoryDesc, String categoryTable) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.categoryTable = categoryTable;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryTable() {
        return categoryTable;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryTable(String categoryTable) {
        this.categoryTable = categoryTable;
    }





}
