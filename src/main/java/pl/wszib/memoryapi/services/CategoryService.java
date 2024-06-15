package pl.wszib.memoryapi.services;

import org.springframework.stereotype.Service;
import pl.wszib.memoryapi.data.entities.CategoryEntity;
import pl.wszib.memoryapi.data.repositories.CategoryRepository;
import pl.wszib.memoryapi.web.models.CategoryRequest;
import pl.wszib.memoryapi.web.models.CategoryResponse;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse createCategory(CategoryRequest request) {
        CategoryEntity categoryEntity = new CategoryEntity(request.name());

        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);

        return new CategoryResponse(savedCategory);
    }
}
