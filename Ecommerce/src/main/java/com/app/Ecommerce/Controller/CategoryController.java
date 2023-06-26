package com.app.ecommerce.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ecommerce.Model.Category;
import com.app.ecommerce.Repository.CategoryRepository;
import com.app.ecommerce.Service.CategoryService;

@RestController
public class CategoryController 
{
    private CategoryService categoryService;
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/create")
    public String createCategoty(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return "Success";      
    }

    @GetMapping(path = "/list")
    public List<Category> listCategory()
    {
        return categoryService.listCategory();
        
    }
}
