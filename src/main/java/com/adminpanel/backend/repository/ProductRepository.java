package com.adminpanel.backend.repository;

import com.adminpanel.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository para la entidad Product
 * Incluye métodos CRUD heredados + métodos personalizados
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Métodos heredados automáticamente:
    // findAll(), findById(), save(), deleteById(), etc.
    
    // Método personalizado: busca productos por ID de categoría
    List<Product> findByCategoryId(Long categoryId);
    
    // Consulta personalizada con @Query: cuenta productos de una categoría
    // para validar antes de eliminar: si hay productos, no eliminar la categoría
    @Query("SELECT COUNT(p) FROM Product p WHERE p.category.id = :categoryId")
    long countByCategoryId(Long categoryId);
}