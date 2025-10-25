package com.tromayastudio.blog.services.impl;

import com.tromayastudio.blog.domain.entities.Category;
import com.tromayastudio.blog.repositories.CategoryRepository;
import com.tromayastudio.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service // this will make the class available for auto-wiring and also inject any dependencies that we declare in this class constructor
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional // so all the database calls happen within one transaction
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category already exists: " +  category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty()) {
                throw new IllegalStateException("Category already has posts: " +  category.get().getPosts().size());
            }
            categoryRepository.deleteById(id);
        }
    }
}
