package com.tromayastudio.blog.services;

import com.tromayastudio.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
