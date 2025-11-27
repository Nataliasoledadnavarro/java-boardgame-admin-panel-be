package com.adminpanel.backend.controller;

import com.adminpanel.backend.exception.CategoryHasProductsException;
import com.adminpanel.backend.model.Category;
import com.adminpanel.backend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import java.util.List;

@RestController  // Indica que esta clase maneja peticiones HTTP y retorna JSON
@RequestMapping("/api/categories")  // Todas las rutas empiezan con /api/categories
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://boardgames-admin-panel-fe.vercel.app"
})
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired  // Spring inyecta el servicio automáticamente
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET /api/categories - Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAll());
        // Retorna: 200 OK + JSON con lista de categorías
    }

    // GET /api/categories/{id} - Obtener categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)           // Si existe → 200 OK + JSON
                .orElse(ResponseEntity.notFound().build());  // Si no → 404 Not Found
    }

    // POST /api/categories - Crear nueva categoría
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        // @Valid: valida @NotBlank, @Size antes de continuar
        // @RequestBody: convierte JSON a objeto Category
        Category created = categoryService.create(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
        // Retorna: 201 CREATED + JSON de la categoría creada
    }

    // PUT /api/categories/{id} - Actualizar categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable Long id,  // ID de la URL
            @Valid @RequestBody Category category) {  // Datos del body
        try {
            Category updated = categoryService.update(id, category);
            return ResponseEntity.ok(updated);  // 200 OK + JSON actualizado
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();  // 404 si no existe
        }
    }

    // DELETE /api/categories/{id} - Eliminar categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        if (categoryService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();  // 404 si no existe
        }
        
        try {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();  // 204 No Content
        } catch (CategoryHasProductsException e) {
            // 409 Conflict con mensaje descriptivo
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}