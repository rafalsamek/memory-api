package pl.wszib.memoryapi.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wszib.memoryapi.services.CategoryService;
import pl.wszib.memoryapi.web.models.CategoryRequest;
import pl.wszib.memoryapi.web.models.CategoryResponse;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> newCategory(CategoryRequest request) {
        CategoryResponse createdCategory = categoryService.createCategory(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }
}
