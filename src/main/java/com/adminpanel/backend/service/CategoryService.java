package com.adminpanel.backend.service;

import com.adminpanel.backend.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category create(Category category);      // POST - crear
    Category update(Long id, Category category);  // PUT - actualizar
    void deleteById(Long id);
}