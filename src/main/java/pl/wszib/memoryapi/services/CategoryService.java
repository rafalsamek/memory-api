package pl.wszib.memoryapi.services;

import org.springframework.stereotype.Service;
import pl.wszib.memoryapi.data.entities.CategoryEntity;
import pl.wszib.memoryapi.data.repositories.CategoryRepository;
import pl.wszib.memoryapi.web.models.CategoryRequest;
import pl.wszib.memoryapi.web.models.CategoryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<CategoryResponse> fetchAll() {
//        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
//
//        categoryEntities.stream().map(CategoryResponse::new).toList();
//
//        List<CategoryResponse> objects = new ArrayList<>();
//        for (CategoryEntity ce : categoryEntities) {
//            objects.add(new CategoryResponse(ce));
//        }

        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::new)
                .toList();
    }

    public CategoryResponse fetchCategory(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(CategoryResponse::new)
                .orElseThrow(NotFoundException::new);

//
//
//        Optional<CategoryEntity> optional = categoryRepository.findById(categoryId);
//
//        CategoryResponse categoryResponse = optional.map(CategoryResponse::new).orElseThrow();
//
//        return categoryResponse;
    }

    public void removeCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
