package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;



@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category category) {
        // Vérifiez si la catégorie existe déjà
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (!existingCategory.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

        // Mettez à jour les champs de la catégorie
        Category updatedCategory = existingCategory.get();
        updatedCategory.setName(category.getName()); // Met à jour le nom
        // Vous pouvez ajouter d'autres mises à jour selon vos besoins

        // Enregistrez la catégorie mise à jour
        return categoryRepository.save(updatedCategory);
    }


    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryDetails(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
}