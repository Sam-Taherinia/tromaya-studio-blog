package com.tromayastudio.blog.services.impl;

import com.tromayastudio.blog.domain.entities.Category;
import com.tromayastudio.blog.repositories.CategoryRepository;
import com.tromayastudio.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // this will make the class available for auto-wiring and also inject any dependencies that we declare in this class constructor
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
