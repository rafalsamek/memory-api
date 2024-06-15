package pl.wszib.memoryapi.services;

import org.springframework.data.crossstore.ChangeSetPersister;
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

    public List<CategoryResponse> listCategories() {
//        List<CategoryResponse> listCategories = new ArrayList<>();
//
//        for (CategoryEntity category : categoryRepository.findAll()) {
//            listCategories.add(new CategoryResponse(category));
//        }
//
//        return listCategories;
//        return categoryRepository.findAll()
//                .stream()
//                .map(c -> new CategoryResponse(c)).toList();
//
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponse::new).toList();
    }

    public CategoryResponse getCategory(Long categoryId) {
//        Optional<CategoryEntity> optional = categoryRepository.findById(categoryId);
//
//        CategoryResponse categoryResponse = optional.map(CategoryResponse::new).orElseThrow();
//
//        return categoryResponse;

        return categoryRepository.findById(categoryId)
                .map(CategoryResponse::new)
                .orElseThrow(NotFoundException::new);
    }
}
