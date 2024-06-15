package pl.wszib.memoryapi.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wszib.memoryapi.data.entities.CardEntity;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
