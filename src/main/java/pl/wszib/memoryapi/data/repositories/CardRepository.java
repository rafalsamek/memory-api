package pl.wszib.memoryapi.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.wszib.memoryapi.data.entities.CardEntity;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {


    @Query(value = "SELECT * from cards WHERE id = :cardId and category_id = :categoryId",
            nativeQuery = true)
    Optional<CardEntity> findByIdAndCategoryId(Long cardId, Long categoryId);

}
