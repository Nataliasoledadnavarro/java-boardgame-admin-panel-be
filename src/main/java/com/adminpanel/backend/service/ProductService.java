package com.adminpanel.backend.service;

import com.adminpanel.backend.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findByCategoryId(Long categoryId);
    Product create(Product product); // POST - crear nuevo producto
    Product update(Long id, Product product); // PUT - actualizar producto existente
    void deleteById(Long id);
}