package com.example.casestudydanang.service;

import com.example.casestudydanang.model.Category;
import com.example.casestudydanang.repository.CategoryDAO;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
