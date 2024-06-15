package pl.wszib.memoryapi.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wszib.memoryapi.data.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
