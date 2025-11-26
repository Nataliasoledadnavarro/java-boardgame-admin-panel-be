package com.adminpanel.backend.repository;

import com.adminpanel.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para la entidad Category
 * Extiende JpaRepository que proporciona métodos CRUD automáticamente
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Métodos heredados automáticamente:
    // - findAll() → Obtiene todas las categorías
    // - findById(Long id) → Busca categoría por ID
    // - save(Category category) → Crea o actualiza una categoría
    // - deleteById(Long id) → Elimina categoría por ID
    // - count() → Cuenta el total de categorías
    // - existsById(Long id) → Verifica si existe una categoría
}