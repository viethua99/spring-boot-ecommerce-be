package com.vproject.ecommercebe.service;

import com.vproject.ecommercebe.payload.CategoryDTO;
import com.vproject.ecommercebe.payload.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(@Valid CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(@Valid CategoryDTO categoryDTO, Long categoryId);
}
