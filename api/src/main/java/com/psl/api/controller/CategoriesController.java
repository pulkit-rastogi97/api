package com.psl.api.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.psl.api.bean.Category;
import com.psl.api.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> list(){
        try{
            List<Category> categories = categoryService.getAllCategories();
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> get(@PathVariable Integer id){
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Category> create(@RequestBody final Category category){
        Category insertedCategory = categoryService.addCategory(category);
        return new ResponseEntity<Category>(insertedCategory,HttpStatus.CREATED);
    }

    @DeleteMapping
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        try {
            boolean isDeleted = categoryService.deleteCategory(id);
            return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
        }catch(NoSuchElementException e) {
            return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Category category){
        try {
            Category updatedCategory = categoryService.updateCategory(category);
            return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

    }

   @RequestMapping(value = "/table_name/{id}")
    public ResponseEntity<String> getCategoryTable(@PathVariable Integer id){
        try{
            String table_name = categoryService.getCategoryTable(id);
            return new ResponseEntity<String>(table_name,HttpStatus.OK);
        }catch(NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
